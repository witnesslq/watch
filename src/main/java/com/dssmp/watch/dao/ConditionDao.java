package com.dssmp.watch.dao;

import com.dssmp.watch.model.MetricCondition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public interface ConditionDao {

    /**
     * 获取所有的查询条件
     *
     * @return
     */
    @Select("select * from watch_condition")
    public List<MetricCondition> findAllMetricCondition();


    /**
     * 根据ID指标查询条件
     *
     * @param id
     * @return
     */
    @Select("select * from watch_condition where id=#{id}")
    public MetricCondition findMetricConditionById(@Param("id") long id);

    /**
     * 添加指标查询条件
     *
     * @param metricCondition
     */
    @Insert("insert into watch_condition(title,metric,mid,week,`condition`,nid,namespace)values(#{title},#{metric},#{mid},#{week},#{condition},#{nid},#{namespace})")
    public void insertMetricCondition(MetricCondition metricCondition);

    /**
     * 删除查询条件
     * @param id
     */
    @Delete("delete from watch_condition where id=#{id}")
    public void deleteMetricCondition(@Param("id") long id);
}

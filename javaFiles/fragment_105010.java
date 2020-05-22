Map<String,Long> mCountMap = getSqlMapClientTemplate().queryForMap("mydata", "", "key", "value");

<resultMap id="hashMapResult" class="java.util.HashMap">
    <result property="key" column="col_1"/>
    <result property="value" column="col_2"/>
</resultMap>

<select id="mydata" resultMap="hashMapResult">
    select col_1, col_2 from sometable
</select>
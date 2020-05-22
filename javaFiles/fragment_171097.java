<select id="select_count" parameterType="map" resultType="map">
    select count(*) as count, TO_CHAR(created_on, #{xaxis}) as xaxis,state 
    from my_table
    where 1 = 1
    <if test="fromdate != null"> and created_on &gt;= #{fromdate} </if>
    <if test="todate != null"> and created_on &lt;= #{todate} </if>
    <if test="state != null"> and state = #{state} </if>
    GROUP BY xaxis, state
</select>
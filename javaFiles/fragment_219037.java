<select id="availabeEmployees" parameterType="java.util.List"
        resultMap="employeeDtoMap">
    <foreach item="item" index="index" collection="list">
        SELECT * FROM Employee e
        WHERE e.location = #{item.location}
        AND e.status = #{item.status}
        <if test="item.last == 'false'">UNION</if>
    </foreach>
</select>
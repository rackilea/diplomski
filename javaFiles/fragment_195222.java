<select id="testSelect" parameterType="map" resultType="Integer">
    select 1 from dual where
    <foreach collection="properties" index="index" item="item" separator=" and ">
        1 = #{id} AND 'a' = #{index,jdbcType=VARCHAR} AND 'b' = #{item,jdbcType=VARCHAR}
    </foreach>
</select>
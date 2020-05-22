<sql id="common-constraints">
    <if test="test1 != '' ">
        AND test1 = #{test1}
    </if>
    <if test="test2 != '' ">
        AND test2 = #{test2}
    </if>
    <if test="test3 != '' ">
        AND test3 = #{test3}
    </if>
</sql>
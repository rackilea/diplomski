<select id="selectList" parameterType="java.util.HashSet" resultMap="someMap">
    SELECT key FROM tb_my_table
    WHERE value IN (
        <foreach collection="collection" item="item" separator=",">
        #{item}
        </foreach>
    )
</select>
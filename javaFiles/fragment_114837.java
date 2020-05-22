<insert id="createNews" parameterType="map" useGeneratedKeys="true" keyColumn="id">
  INSERT INTO t
    <foreach item="key" collection="Key" index="index" open="(" separator="," close=")">
        ${key}
    </foreach>
    VALUES
    <foreach item="value" collection="Value" index="index" open="(" separator="," close=")">
        #{value}
    </foreach>
</insert>
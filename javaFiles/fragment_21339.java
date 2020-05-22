<select id="removeSomeStuff" parameterType="map" resultType="long" flushCache="true">

    delete from some_stuff where some_id in
    <foreach collection="someIds" item="someId" 
            index="index" 
            open="(" separator="," close=")">
        #{someId}
    </foreach>

    and another_stuff in

    <foreach collection="someAnotherIds" item="someAnotherId" 
             index="index" 
             open="(" separator="," close=")">
        #{someAnotherId}
    </foreach>
    RETURNING id
</select>
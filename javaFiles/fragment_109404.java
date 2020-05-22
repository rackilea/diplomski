User getUserById(@Param("id") Integer id);
<select id="getUserById" resultMap="userMap">
    select name,age
    from user
    where id=#{id, jdbcType=INTEGER}
<select/>
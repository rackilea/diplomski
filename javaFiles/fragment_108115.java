//call the dao method
String columns = "first_name";
HashMap map = new HashMap();
map.put("userId",userId);
map.put("columns",columns);
userDao.sample(map);

//call mapper
List<User> sample(HashMap map);

//mapper
<select id="sample" resultMap="user" parameterType="map">
    SELECT
        #{columns}
    FROM
        user
    WHERE
        userId = #{userId}
</select>
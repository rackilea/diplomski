List<RealTimeDTO> query(String name, String phone, int age) {
    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    StringJoiner where = new StringJoiner(" AND ", " WHERE ", "").setEmptyValue("");
    if (name != null)
        where.add("name = :name");
    if (phone != null)
        where.add("phone = :phone");
    if (age != 0)
        where.add("age = :age");
    String sql = "SELECT foo, bar" +
                  " FROM FooBar" +
                  where;
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    params.put("phone", phone);
    params.put("age", age);
    return jdbcTemplate.query(sql, params, new CCCRowMapper());
}
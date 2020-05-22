List<RealTimeDTO> query(String name) {
    NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    String sql = "SELECT foo, bar" +
                  " FROM FooBar" +
                 " WHERE name" + (name == null ? " IS NULL" : "= :name");
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    return jdbcTemplate.query(sql, params, new CCCRowMapper());
}
@Autowired
private NamedParameterJdbcTemplate  jdbcTemplate;

// ...

MapSqlParameterSource p = new MapSqlParameterSource("name", "value");
p.addValue("anotherParam", true);
List<Map<String, Object>> result = jdbcTemplate.queryForList("select ... where id = :name", p);
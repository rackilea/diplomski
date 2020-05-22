Set<Integer> ids = ...;

MapSqlParameterSource parameters = new MapSqlParameterSource();
parameters.addValue("ids", ids);

List<Foo> foo = getJdbcTemplate().query("SELECT * FROM foo WHERE a IN (:ids)",
     parameters, getRowMapper());
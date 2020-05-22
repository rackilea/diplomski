String SQL = INSERT INTO TABLE_NAME VALUES((:id),...);

MapSqlParameterSource parameters = new MapSqlParameterSource();
parameters.addValue("id", "idValue");
//...
namedParameterJdbcTemplate.update(SQL, parameters) > 0;
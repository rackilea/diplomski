String sqlstr = "select * from the_table where lastname like :lastname or :lastname is null"

NamedParameterJdbcTemplate jt = new NamedParameterJdbcTemplate(datasource);

Map namedParameters = new HashMap();
namedParameters.put("lastname", "%test%");
SqlRowSet result = jt.queryForRowSet( sqlstr ,namedParameters );
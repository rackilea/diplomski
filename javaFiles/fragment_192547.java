ParsedSql parsedSql = NamedParameterUtils.parseSqlStatement("SELECT id FROM emp WHERE age=:age");
SqlParameterSource source = new MapSqlParameterSource("age", 19);
String finalQuery = new PreparedStatementCreatorFactory(NamedParameterUtils.substituteNamedParameters(parsedSql,
                source), NamedParameterUtils.buildSqlTypeArray(parsedSql, source))
                .newPreparedStatementCreator(NamedParameterUtils.buildValueArray(parsedSql, source, null))
                .createPreparedStatement(getConnection()).toString();

finalQuery = finalQuery.substring(finalQuery.indexOf(":") + 1, finalQuery.length());
System.out.println(finalQuery);
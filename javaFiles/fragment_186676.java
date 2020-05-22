LOGGER.info("Calling stored proc...");
    SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("test").withProcedureName("test_proc");
    SqlParameterSource in = new MapSqlParameterSource().addValue("name", "akshay");
    Map<String, Object> out = simpleJdbcCall.execute(in);
    LOGGER.info("Output from procedure: {}", out.get("fullname"));
    LOGGER.info("Returned from stored proc.");
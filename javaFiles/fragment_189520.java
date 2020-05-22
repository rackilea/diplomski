SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(template)
    .withProcedureName("customerDetails");
    Map<String, Object> inParamMap = new HashMap<String, Object>();
    inParamMap.put("id", 1);
    SqlParameterSource in = new MapSqlParameterSource(inParamMap);
    Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
    System.out.println(simpleJdbcCallResult);
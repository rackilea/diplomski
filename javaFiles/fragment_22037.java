SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
    .withSchemaName(schema)
    .withCatalogName(package)
    .withProcedureName(procedure)();
...
jdbcCall.addDeclaredParameter(new SqlParameter(paramName, OracleTypes.NUMBER));
...
jdbcCall.execute(callParams);
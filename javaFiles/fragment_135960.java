DriverManagerDataSource ds = new DriverManagerDataSource();
ds.setDriverClassName("com.mysql.jdbc.Driver");
ds.setUrl("jdbc:mysql://server/test?characterEncoding=utf8");
ds.setUsername("user");  
ds.setPassword("pass");

// must explicitly declare params
SimpleJdbcCall jdbc = new SimpleJdbcCall(ds)
    .withProcedureName("sp_gms_addGameTranslationsTest")
    .declareParameters(
        new SqlParameter("_test", Types.VARCHAR)
);

SqlParameterSource in = new MapSqlParameterSource()
    .addValue("_test", "그러나 사디라");

jdbc.execute(in);
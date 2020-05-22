@Bean
public DataSource dataSource() {
  JndiDataSourceLookup dataSourceLookup = new JndiDataSourceLookup();

  dataSourceLookup.setResourceRef(true);

  DataSource dataSource = dataSourceLookup.getDataSource("castle/db");

  return dataSource;
}

 @Bean
 public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
   return new NamedParameterJdbcTemplate(dataSource);

}
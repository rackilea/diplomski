@Bean
 public FooService fooService() {
     return new FooService(fooRepository());
 }

 @Bean
 public FooRepository fooRepository() {
     return new JdbcFooRepository(dataSource());
 }
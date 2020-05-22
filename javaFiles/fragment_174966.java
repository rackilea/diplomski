@Bean
  public DataSource dynamicDataSource() {
    ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("file:///C:/Users/xxxx/Desktop/h2-1.4.193.jar")}, Thread.currentThread().getContextClassLoader());
    Thread.currentThread().setContextClassLoader(classLoader);
    DataSource dataSource = DataSourceBuilder.create().url('jdbc:h2:mem:test;DB_CLOSE_DELAY=-1').build();
    dataSource.getConnection().isValid(10);
    return dataSource;
  }
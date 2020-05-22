@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
  Map<String, Object> properties = new Hashtable<>();
  properties.put(
      "javax.persistence.schema-generation.database.action",
      "none");

  HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();

  //you will chose a dialect that you are using for your project.
  adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5InnoDBDialect");  

  LocalContainerEntityManagerFactoryBean factory = 
      new LocalContainerEntityManagerFactoryBean();
  factory.setJpaVendorAdapter(adapter);
  factory.setDataSource(this.springJpaDataSource());

  //the packages that contains you @Repositories annotations
  factory.setPackagesToScan("packagenames"); 

  factory.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE);
  factory.setValidationMode(ValidationMode.NONE);
  factory.setJpaPropertyMap(properties);
  return factory;
}
@Bean(name = "entityManagerFactory")
public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setDataSource(dataSource());
    entityManagerFactory.setPersistenceUnitName("postgres");
    entityManagerFactory.setJpaProperties(jpaProperties());
    entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
    entityManagerFactory.setJpaDialect(jpaDialect());
    entityManagerFactory.setPackagesToScan("net.jkratz.bloodpressure.api.model");
    return entityManagerFactory;
}
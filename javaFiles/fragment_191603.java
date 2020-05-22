@Bean
public EntityManagerFactory entityManagerFactory() throws SQLException {

    final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
    factoryBean.setDataSource(dataSource());
    factoryBean.setJpaDialect(new HibernateJpaDialect());
    factoryBean.setJpaProperties(getHibernateProperties());
    factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    factoryBean.setPackagesToScan("com.lcbo.batch.domain");
   factoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    factoryBean.setPersistenceUnitName("persistenceUnit");
    factoryBean.afterPropertiesSet();


    return factoryBean.getObject();
}
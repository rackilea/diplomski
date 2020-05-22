@Bean(name = "readingEntityManagerFactory")
public EntityManagerFactory readingEntityManagerFactory() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setPersistenceUnitName("persistence.reading");
    em.setDataSource(dataSource());
    em.setPackagesToScan("com.company");
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.afterPropertiesSet();
    return em.getObject();
}
@Bean
public SessionFactory sessionFactory() {
    LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
    localSessionFactoryBean.setDataSource(dataSource());
    localSessionFactoryBean.setPackagesToScan(new String[] { "com.migration.core.domain.*" });
    localSessionFactoryBean.setMappingLocations(loadResources());
    localSessionFactoryBean.setHibernateProperties(hibernateProperties());
    return localSessionFactoryBean.getObject(); // here is the important change
}
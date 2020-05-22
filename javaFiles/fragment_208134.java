@Bean
@Autowired
public PlatformTransactionManager transactionManager(SessionFactory s) {
   HibernateTransactionManager txManager = new HibernateTransactionManager();
   txManager.setSessionFactory(s);
   return txManager;
}

@Bean
public SessionFactory sessionFactory() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.show_sql", "true")
    properties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory")
    properties.setProperty("hibernate.cache.use_query_cache", "true")
    properties.setProperty("hibernate.cache.use_second_level_cache", "true")
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect")

    return new LocalSessionFactoryBuilder(dataSource())
        .scanPackages("dto")
        .addProperties(properties)
        .buildSessionFactory();
}
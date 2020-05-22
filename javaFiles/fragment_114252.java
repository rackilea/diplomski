@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.xxxxxx.configuration.hib" })

public class HibernateConfiguration {


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.XXXXXX.spring.component" });
        sessionFactory.setHibernateProperties(hibProperties());
        return sessionFactory;
     }

    @Bean
    public DataSource dataSource() {
        return driverManagerDataSource;
    }
    private Properties hibProperties() {
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2012Dialect");
        properties.put(Environment.SHOW_SQL, false);
        properties.put(Environment.USE_SECOND_LEVEL_CACHE,true);
        properties.put(Environment.CACHE_REGION_FACTORY,"org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
        properties.put(Environment.CACHE_PROVIDER_CONFIG,"/ehcache.xml");
        properties.put(Environment.USE_QUERY_CACHE, true);
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }
}
@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:hibernate.properties" })
public class RepositoryConfiguration {

@Autowired
private Environment environment;

@Bean(name = "sessionFactory")
public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setHibernateProperties(hibernateProperties());
    sessionFactory.setPackagesToScan(new String[] { "com.project" });
    return sessionFactory;
}

@Bean
public Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect",    environment.getRequiredProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
    properties.put("hibernate.hbm2ddl.auto", "update");// environment.getRequiredProperty("hibernate.hbm2ddl.auto")
return properties;
}

@Bean(name = "sessionFactory2")
public LocalSessionFactoryBean sessionFactory2() {
    LocalSessionFactoryBean sessionFactory2 = new  LocalSessionFactoryBean();
    sessionFactory2.setDataSource(dataSource());
    sessionFactory2.setHibernateProperties(hibernateProperties2());
    sessionFactory2.setPackagesToScan(new String[] { "com.server" });
    return sessionFactory2;
}

@Bean
public Properties hibernateProperties2() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect2"));
    properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql2"));
    properties.put("hibernate.hbm2ddl.auto", "update2");// environment.getRequiredProperty("hibernate.hbm2ddl.auto")
    return properties;
}

@Bean(name = "datasource2")
public DataSource dataSource2() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName2"));
       dataSource.setUrl(environment.getRequiredProperty("jdbc.url2"));
   dataSource.setUsername(environment.getRequiredProperty("jdbc.username2"));
   dataSource.setPassword(environment.getRequiredProperty("jdbc.password2"));
    return dataSource;
}

@Bean(name = "datasource")
public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
    dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
return dataSource;
    }

@Autowired
@Qualifier("sessionFactory")
private SessionFactory sessionFactory;

@Autowired
@Qualifier("sessionFactory2")
private SessionFactory sessionFactory2;

@Bean(name = "sessionFactoryTransactionManager")
public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager txManager = new HibernateTransactionManager();
    txManager.setSessionFactory(this.sessionFactory);
     return txManager;
}

@Bean(name = "sessionFactory2TransactionManager")
 public HibernateTransactionManager transactionManager2() {
    HibernateTransactionManager txManager2 = new HibernateTransactionManager();
    txManager2.setSessionFactory(this.sessionFactory2);
    return txManager2;
}

}
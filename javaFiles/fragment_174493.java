@Configuration
public class DataSourcesConfig {

    @Bean(name = "datasource1")
    public DriverManagerDataSource dataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        ...
        return dataSource;
    }

    @Bean(name = "datasource2")
    public DriverManagerDataSource dataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        ...
        return dataSource;
    }
}

@Configuration
public class EntityManagerFactoriesConfiguration {

    @Autowired
    @Qualifier("datasource1")
    private DataSource dataSource1;

    @Autowired
    @Qualifier("datasource2")
    private DataSource dataSource2;


    @Bean(name = "entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource1);
        entityManagerFactoryBean.setPackagesToScan(new String[] { "your.package.here" });
        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> jpaProperties = new HashMap<String, Object>();
        ...
        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);

        return entityManagerFactoryBean;
    }

    @Bean(name = "entityManagerFactory2")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean2() {

        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource2);
        entityManagerFactoryBean.setPackagesToScan(new String[] { "your.package.here" });
        entityManagerFactoryBean.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Map<String, Object> jpaProperties = new HashMap<String, Object>();

        entityManagerFactoryBean.setJpaPropertyMap(jpaProperties);
        ...
        return entityManagerFactoryBean;
    }
}     


@Configuration
@EnableTransactionManagement
public class TransactionManagersConfig {

    @Autowired
    @Qualifier("entityManagerFactory1")
    EntityManagerFactory entityManagerFactory1;

    @Autowired
    @Qualifier("entityManagerFactory2")
    EntityManagerFactory entityManagerFactory2;

    @Autowired
    @Qualifier("datasource1")
    private DataSource dataSource1;

    @Autowired
    @Qualifier("datasource2")
    private DataSource dataSource2;

    @Bean(name = "transactionManager1")
    public PlatformTransactionManager transactionManager1() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory1);
        transactionManager.setDataSource(dataSource1);
        return transactionManager;
    }

    @Bean(name = "transactionManager2")
    public PlatformTransactionManager transactionManager2() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory2);
        transactionManager.setDataSource(dataSource2);
        return transactionManager;
    }
}
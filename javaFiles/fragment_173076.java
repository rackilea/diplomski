@EnableJpaRepositories
@Configuration
@EnableTransactionManagement
public class MainConfig {
    private Properties hibernateProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDB10Dialect");
        return props;
    }

    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();
        properties.put("url", "jdbc:mariadb://localhost:3306/myDatabase");
        properties.put("user", "root");
        properties.put("password", "myPassword");

        HikariConfig config = new HikariConfig();
        config.setDataSourceClassName("org.mariadb.jdbc.MariaDbDataSource");
        config.setMaximumPoolSize(10);
        config.setDataSourceProperties(properties);

        return new HikariDataSource(config);
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager jpaTxManager = new JpaTransactionManager();
        jpaTxManager.setEntityManagerFactory(emf);
        return jpaTxManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        HibernateJpaDialect jpaDialect = new HibernateJpaDialect();
        emf.setJpaDialect(jpaDialect);
        emf.setJpaProperties(hibernateProperties());
        emf.setPackagesToScan("mypackage");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        emf.setJpaVendorAdapter(vendorAdapter);

        return emf;
    }
}
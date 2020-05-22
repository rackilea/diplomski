private static final String H2_JDBC_URL_TEMPLATE = "jdbc:h2:%s/target/db/sample;AUTO_SERVER=TRUE";
@Value("classpath:seed-data.sql")
private Resource H2_SCHEMA_SCRIPT;

@Value("classpath:test-data.sql")
private Resource H2_DATA_SCRIPT;

@Value("classpath:drop-data.sql")
private Resource H2_CLEANER_SCRIPT;


@Bean
public DataSource dataSource(Environment env) throws Exception {
        return createH2DataSource();
}


@Autowired
@Bean
public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {

    final DataSourceInitializer initializer = new DataSourceInitializer();
    initializer.setDataSource(dataSource);
    initializer.setDatabasePopulator(databasePopulator());
    initializer.setDatabaseCleaner(databaseCleaner());
    return initializer;
}


private DatabasePopulator databasePopulator() {
    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(H2_SCHEMA_SCRIPT);
    populator.addScript(H2_DATA_SCRIPT);
    return populator;
}

private DatabasePopulator databaseCleaner() {
    final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
    populator.addScript(H2_CLEANER_SCRIPT);
    return populator;
}

private DataSource createH2DataSource() {
    String jdbcUrl = String.format(H2_JDBC_URL_TEMPLATE, System.getProperty("user.dir"));
    JdbcDataSource ds = new JdbcDataSource();       
    ds.setURL(jdbcUrl);
    ds.setUser("sa");
    ds.setPassword("");

    return ds;
}

@Bean
public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
}

@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory(Environment env) throws Exception {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(Boolean.TRUE);
    vendorAdapter.setShowSql(Boolean.TRUE);     

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setPersistenceUnitName("sample");
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("com.sample.model");
    factory.setDataSource(dataSource(env));     

    factory.setJpaProperties(jpaProperties());
    factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());

    return factory;
}

Properties jpaProperties() {
    Properties props = new Properties();
    props.put("hibernate.query.substitutions", "true 'Y', false 'N'");
    props.put("hibernate.hbm2ddl.auto", "create-drop");
    props.put("hibernate.show_sql", "false");
    props.put("hibernate.format_sql", "true");

    return props;
}
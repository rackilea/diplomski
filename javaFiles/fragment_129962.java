@Configuration
@EnableTransactionManagement
@ComponentScan("com.bonkeybee")
public class ApplicationConfiguration {

    @Bean
    public DataSource getDataSource() throws PropertyVetoException {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(JDBC_DRIVER);
        comboPooledDataSource.setJdbcUrl(JDBC_URL);
        comboPooledDataSource.setUser(USER);
        comboPooledDataSource.setPassword(PASSWORD);
        comboPooledDataSource.setMinPoolSize(MIN_POOL_SIZE);
        comboPooledDataSource.setInitialPoolSize(MIN_POOL_SIZE);
        comboPooledDataSource.setMaxPoolSize(MAX_POOL_SIZE);
        return comboPooledDataSource;
    }

    @Inject
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getPlatformTransactionManager(final DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public com.querydsl.sql.Configuration getQueryDslConfiguration() {
        return new com.querydsl.sql.Configuration(PostgreSQLTemplates.builder().build());
    }

    @Inject
    @Bean
    public SQLQueryFactory getSQLQueryFactory(final com.querydsl.sql.Configuration configuration, final DataSource dataSource) {
        Provider<Connection> provider = new SpringConnectionProvider(dataSource);
        return new SQLQueryFactory(configuration, provider);
    }
}
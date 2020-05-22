@Autowired
public DataSource dataSource;

@Bean
public PlatformTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource);
}

@Bean
public com.querydsl.sql.Configuration querydslConfiguration() {
    SQLTemplates templates = H2Templates.builder().build();
    com.querydsl.sql.Configuration configuration = new com.querydsl.sql.Configuration(templates);

    configuration.setExceptionTranslator(new SpringExceptionTranslator());

    return configuration;
}

@Bean
public SQLQueryFactory queryFactory() {
    Provider<Connection> provider = new SpringConnectionProvider(dataSource);
    return new SQLQueryFactory(querydslConfiguration(), provider);
}
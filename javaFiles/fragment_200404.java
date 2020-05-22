public SqlSessionFactory build() throws IOException, SQLException
{       
    OracleDataSource dataSource = new OracleDataSource();
    dataSource.setURL(this.dbUrl);
    dataSource.setUser(this.dbUsername);
    dataSource.setPassword(this.dbPassword);
    dataSource.setDriverType(properties.getProperty("db.driver"));
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment(properties.getProperty("db.environment"), transactionFactory, dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMappers("com.app.dao");
    SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    // final test connection to db
    sessionFactory.openSession().getConnection();
    return sessionFactory;
}
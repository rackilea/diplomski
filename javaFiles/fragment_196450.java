@Autowired
Environment env;

@Bean
@ConfigurationProperties(prefix="datasource.secondary")
    public BasicDataSource DBDataSource() {
        // Notice this line
        System.out.println("DBUrl: " + env.getProperty("db_name.db.url"));

        BasicDataSource DBDataSource = new BasicDataSource();

        DWDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        DWDataSource.setUrl(DBUrl);
        DWDataSource.setUsername("user");
        DWDataSource.setPassword("pass");
        DWDataSource.setMaxIdle(10);
        DWDataSource.setMaxWaitMillis(10000);
        DWDataSource.setValidationQuery("select 1");
        DWDataSource.setTestOnBorrow(false);
        DWDataSource.setTestWhileIdle(true);
        DWDataSource.setDefaultAutoCommit(true);

        return DBDataSource;

    }
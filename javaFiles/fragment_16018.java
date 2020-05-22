@Configuration
public class DatasourceConfiguration {

    @Value("${spring.datasource.username}")
    private String user;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.connectionTestQuery}")
    private String connectionTestQuery;

    @Autowired
    private MetricRegistry metricRegistry;

    @Bean
    public DataSource primaryDataSource() {
        Properties dsProps = new Properties();
        dsProps.setProperty("url", dataSourceUrl);
        dsProps.setProperty("user", user);
        dsProps.setProperty("password", password);

        Properties configProps = new Properties();
        configProps.setProperty("connectionTestQuery", connectionTestQuery);
        configProps.setProperty("driverClassName", driverClassName);
        configProps.setProperty("jdbcUrl", dataSourceUrl);

        HikariConfig hc = new HikariConfig(configProps);
        hc.setDataSourceProperties(dsProps);
        hc.setMetricRegistry(metricRegistry);
        return new HikariDataSource(hc);
    }
}
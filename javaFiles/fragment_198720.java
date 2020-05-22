@Autowired
private DataSource requiredDataSource;

@Bean
public DataSourceHealthIndicator requiredDataSourceHealthIndicator() {
    return new DataSourceHealthIndicator(requiredDataSource);
}
@ConfigurationProperties(prefix = "datasource.postgres")
@Bean
@Primary
public DataSource dataSource() {
    return DataSourceBuilder
        .create()
        .build();
}
@Bean(name = "primaryDataSource")
@Primary
@ConfigurationProperties(prefix = "spring.datasource.primary")
public DataSource primaryDataSource() {
    return DataSourceBuilder.create().build();
}
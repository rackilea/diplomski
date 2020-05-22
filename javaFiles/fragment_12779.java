/**
 * Config class holding several datasources, one business related, other for the spring batch jobs
 */
@Configuration
public class DataSourceConfiguration
{
    @Bean
    @Qualifier("businessDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource primaryDataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    @Qualifier("jobsDataSource")
    @ConfigurationProperties(prefix = "spring.secondDatasource")
    public DataSource secondaryDataSource()
    {
        return DataSourceBuilder.create().build();
    }
}
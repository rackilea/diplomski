@Configuration
public class AlternateDataSourcePropertiesConfiguration {
   @Bean
    @ConfigurationProperties("app.datasource.alternate")
    public DataSourceProperties alternateDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
}
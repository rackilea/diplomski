@Configuration
public class BatchTestDatabaseConfig {
    @Bean
    @Primary
    public DataSource dataSource()
    {
        return .........;
    }
}
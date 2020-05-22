@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.so.repository")
public class RepositoryConfig {
    @Bean
    public DataSource dataSource() { ... }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() { ... }

    @Bean
    public PlatformTransactionManager transactionManager() { ... }
}
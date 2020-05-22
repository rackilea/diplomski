@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages"package.repository"})
public class RootConfig {
    @Bean
    public DataSource dataSource() {
        ...
        return dataSource;
    }
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        ...
        return hibernateJpaVendorAdapter;
    }
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        ...
        return factory.getObject();
    }
    @Bean
    public JpaTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
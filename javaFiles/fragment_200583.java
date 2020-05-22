@Configuration
@EnableJpaRepositories(
        basePackages = { "org.company.project.repository.buffalo"},
        entityManagerFactoryRef = "buffaloEntityManagerFactory",
        transactionManagerRef = "buffaloTransactionManager")
public class BuffaloDbConfiguration {

    @Bean(name = "buffaloDataSource")
    @ConfigurationProperties(prefix = "buffalo.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "buffaloEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("buffaloDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("org.company.project.domain")
                .properties(jpaProperties())
                .build();
    }

    public Map<String, Object> jpaProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        props.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());
        return props;
    }

    @Bean(name = "buffaloTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("buffaloEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
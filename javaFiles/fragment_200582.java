@Configuration
@EnableJpaRepositories(
        basePackages = { "org.company.project.repository.albany"},
        entityManagerFactoryRef = "albanyEntityManagerFactory",
        transactionManagerRef = "albanyTransactionManager")
public class AlbanyDbConfiguration {

    @Primary
    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "albanyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
        entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
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

    @Primary
    @Bean(name = "albanyTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("albanyEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
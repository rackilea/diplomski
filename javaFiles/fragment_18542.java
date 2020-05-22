@Configuration
@EnableJpaRepositories(basePackages = "io.eddumelendez.springdatajpa.repository1")
public class FirstConfiguration {

    @ConfigurationProperties(prefix = "datasource.postgres")
    @Bean
    @Primary
    public DataSource postgresDataSource() {
        return DataSourceBuilder.create().
                build();
    }

    @Bean(name = "entityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean emf1(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(postgresDataSource())
                .packages("io.eddumelendez.springdatajpa.domain1")
                .persistenceUnit("users")
                .build();
    }

}
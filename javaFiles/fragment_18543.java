@Configuration
@EnableJpaRepositories(basePackages = "io.eddumelendez.springdatajpa.repository2", entityManagerFactoryRef = "emf2")
public class SecondConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean emf2(EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(mysqlDataSource())
                .packages("io.eddumelendez.springdatajpa.domain2")
                .persistenceUnit("customers")
                .build();
    }

}
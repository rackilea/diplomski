@RequiredArgsConstructor
@PropertySource({"classpath:persistence/persistence-primarydb.properties"})
@EnableJpaRepositories(basePackages = "io.vforge.cauldron.repository.primary",
        entityManagerFactoryRef = "primaryEntityManagerFactory",
        transactionManagerRef = "primaryTransactionManager")
@EnableJpaAuditing
@Configuration
public class CauldronPrimaryDatasource {

    private final Environment env;

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primaryDataSource());
        em.setPackagesToScan("io.vforge.cauldron.model.primary");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("primary.hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("primary.hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("primary.hibernate.show_sql"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public HikariDataSource primaryDataSource() {
        final HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl(env.getProperty("primary.datasource.url"));
        dataSource.setUsername(env.getProperty("primary.datasource.username"));
        dataSource.setPassword(env.getProperty("primary.datasource.password"));
        return dataSource;
    }

    @Primary
    @Bean
    public PlatformTransactionManager primaryTransactionManager() {
        JpaTransactionManager transactionManager= new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                primaryEntityManagerFactory().getObject());
        return transactionManager;
    }

}
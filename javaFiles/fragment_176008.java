@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException
    {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setJpaVendorAdapter(envConfig.jpaVendorAdapter());
        factory.setPackagesToScan("java.pkg.pkg1","java.pkg.pkg2");
            factory.setPersistenceUnitName("greatUnitName");

        return factory;
    }

    @Bean
    public EntityManager entityManager() throws SQLException
    {
        return entityManagerFactory().getObject().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException
    {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }

    //... snip DataSource setup
private Map<String, String> jpaProperties() {

    Map<String, String> p = new HashMap<String, String>();

    p.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
    p.put("hibernate.id.new_generator_mappings",
            env.getProperty("spring.jpa.properties.hibernate.id.new_generator_mappings"));
    p.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
    p.put("hibernate.naming.physical-strategy", env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
    p.put("hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));

    return p;
}



@Bean
@ConfigurationProperties(prefix = "modules.datasource")
public DataSource modulesDataSource() {
    return DataSourceBuilder.create().build();
}

@Bean
@Primary
@ConfigurationProperties(prefix = "supplychain.datasource")
public DataSource supplychainDataSource() {
    return DataSourceBuilder.create().build();
}

@Bean(name="modules")
public LocalContainerEntityManagerFactoryBean modulesEntityManagerFactory(
        org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder) throws IOException {
    return builder.dataSource(modulesDataSource()).packages(Moduli.class).properties(jpaProperties()).persistenceUnit("JPAModules").build();
}

@Bean(name="supplychain")
@Primary
public LocalContainerEntityManagerFactoryBean supplychainEntityManagerFactory(EntityManagerFactoryBuilder builder)
        throws IOException {
    return builder.dataSource(supplychainDataSource()).packages(Rent.class).properties(jpaProperties()).persistenceUnit("JPASupplychain").build();
}

@Bean(name = "modulesTransactionManager")
public PlatformTransactionManager modulesTransactionManager(EntityManagerFactoryBuilder builder)
        throws IOException {
    JpaTransactionManager tm = new JpaTransactionManager();
    tm.setEntityManagerFactory(modulesEntityManagerFactory(builder).getObject());
    tm.setDataSource(modulesDataSource());
    return tm;
}

@Bean(name = "supplychainTransactionManager")
@Primary
public PlatformTransactionManager supplychainTransactionManager(EntityManagerFactoryBuilder builder)
        throws IOException {
    JpaTransactionManager tm = new JpaTransactionManager();
    tm.setEntityManagerFactory(supplychainEntityManagerFactory(builder).getObject());
    tm.setDataSource(supplychainDataSource());
    return tm;
}
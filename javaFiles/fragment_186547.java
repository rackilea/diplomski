@Bean
public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

    DataSource dataSource = dataSource();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    entityManagerFactoryBean.setJpaProperties(jpaProperties());
    entityManagerFactoryBean.setPackagesToScan("com.kefet.controller");

    return entityManagerFactoryBean;
}

@Bean
public HibernateExceptionTranslator hibernateExceptionTranslator() {
    return new HibernateExceptionTranslator();
}

protected Properties jpaProperties() {
    Properties jpaProperties = new Properties();
    jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
    jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, false);
    return jpaProperties;
}
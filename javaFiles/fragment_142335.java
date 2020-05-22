@Bean(name="entityManagerFactoryBean")
public EntityManagerFactory configureEntityManagerFactory() {

    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(getDataSource());
    entityManagerFactoryBean.setPackagesToScan("com.global.us.app.model.db");
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

    Properties jpaProperties = new Properties();
    jpaProperties.put(org.hibernate.cfg.Environment.DIALECT, env.getProperty(org.hibernate.cfg.Environment.DIALECT));
    jpaProperties.put(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty(org.hibernate.cfg.Environment.SHOW_SQL));
    jpaProperties.put(org.hibernate.cfg.Environment.HBM2DDL_IMPORT_FILES_SQL_EXTRACTOR, env.getProperty(org.hibernate.cfg.Environment.HBM2DDL_IMPORT_FILES_SQL_EXTRACTOR));
    entityManagerFactoryBean.setJpaProperties(jpaProperties);

    entityManagerFactoryBean.afterPropertiesSet();

    return (EntityManagerFactory) entityManagerFactoryBean.getObject();
} 


@Override
@Bean()
@DependsOn("entityManagerFactoryBean")
public PlatformTransactionManager annotationDrivenTransactionManager() {
    JpaTransactionManager jpa =  new JpaTransactionManager();
    jpa.setEntityManagerFactory(configureEntityManagerFactory());
    return jpa;
}
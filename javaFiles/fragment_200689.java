@Bean
LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
    LocalContainerEntityManagerFactoryBean b = new LocalContainerEntityManagerFactoryBean();
    b.setPersistenceUnitName("productPU");
    ...
    return b;
}

@Bean
JpaTransactionManager jpaTransactionManager(LocalContainerEntityManagerFactoryBean emf) {
    JpaTransactionManager tm = new JpaTransactionManager();
    tm.setEntityManagerFactory(emf);
    return tm;
}
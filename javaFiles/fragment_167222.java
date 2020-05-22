@Bean
public PlatformTransactionManager transactionManager(EntityManagerFactory emf, DataSource ds) {
    JpaTransactionManager jtm = new JpaTransactionManager();
    jtm.setEntityManagerFactory(emf);
    return jtm;
}
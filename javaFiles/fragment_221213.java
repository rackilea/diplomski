@Bean
public JpaTransactionManager jpaTransactionManager() {
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = this.getEntityManagerFactoryBean();
    EntityManagerFactory ef = (EntityManagerFactory)localContainerEntityManagerFactoryBean.getObject();
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(ef);
    return transactionManager;
}
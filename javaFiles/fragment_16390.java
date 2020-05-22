@Bean(name = "readingTransactionManager")
public PlatformTransactionManager readingTransactionManager(){
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(readingEntityManagerFactory());
    return transactionManager;
}
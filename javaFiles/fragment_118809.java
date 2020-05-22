@Bean
public PlatformTransactionManager transactionManager() {
  JpaTransactionManager manager = new JpaTransactionManager();
  txManager.setEntityManagerFactory(entityManager().getObject());
  return manager;
}
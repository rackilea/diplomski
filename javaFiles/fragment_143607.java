try {
  transactionManager.getTransaction();
  readOperations();
  transactionManager.commit();
} catch (Exception e) {
  log(e);
}
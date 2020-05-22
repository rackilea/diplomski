public afterCompletion(int status) {
  if(Status.STATUS_COMMITTED == status) {
    try { transactionManager.rollback(); } catch (Throwable t) {}
    service.deleteAccounts();
  }
}
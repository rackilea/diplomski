public afterCompletion(int status) {
  if(Status.STATUS_COMMITTED == status) {
    try { 
      transactionManager.begin();
      service.deleteAccounts();
      transactionManager.commit();
    } catch (Exception e) {
        // ... handle exception here
    }
  }
}
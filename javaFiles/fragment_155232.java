transactionTemplate.execute(transactionStatus -> {
    try {
      ...
    } catch (ProcessingAlertException ex) {
      transactionStatus.setRollbackOnly();
    }
});
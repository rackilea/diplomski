@Autowired
JtaTransactionManager txManager;  //from Spring

javax.transaction.TransactionManager jtaTransactionManager;

public void parallelInserts() {
    jtaTransactionManager = txManager.getTransactionManager();  //we are getting the underlying implementation
    jtaTransactionManager.begin();
    final Transaction jtaTransaction  = jtaTransactionManager.getTransaction();
    try {
      Thread t1 = new Thread(){
        @Override
        public void run() {
            try {
                jtaTransactionManager.resume(jtaTransaction);
                //... do the insert
            } catch (InvalidTransactionException e) {
                try {
                    jtaTransaction.setRollbackOnly();
                } catch (SystemException e1) {
                    e1.printStackTrace();
                }
                e.printStackTrace();
            } catch (SystemException e) {
                e.printStackTrace();
            }
        }
      };
      t1.start();
      //same with t2 and t3
    } catch (Exception ex) {
        jtaTransactionManager.setRollbackOnly();
        throw ex;
    }
    //join threads and commit
    jtaTransactionManager.commit();
}
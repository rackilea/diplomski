// single TransactionTemplate shared amongst all methods in this instance
private final TransactionTemplate transactionTemplate;

// use constructor-injection to supply the PlatformTransactionManager
public SimpleService(PlatformTransactionManager transactionManager) {
    Assert.notNull(transactionManager, "The 'transactionManager' argument must not be null.");
    this.transactionTemplate = new TransactionTemplate(transactionManager);
}

public Object someServiceMethod() {
    return transactionTemplate.execute(new TransactionCallback() {

        // the code in this method executes in a transactional context
        public Object doInTransaction(TransactionStatus status) {
            updateOperation1();
            return resultOfUpdateOperation2();
        }
    });
}
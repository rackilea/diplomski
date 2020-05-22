public class MyTransactionalManager implements PlatformTransactionManager {
// ... implementation via delegation skipped here
    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        defaultManager.commit(status);
        // You might want to check status.isRollbackOnly() here
        someService.thisMethodFiresOnEndOfTransaction();
}
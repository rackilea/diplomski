public class MyTransactionManager implements PlatformTransactionManager {
    private final PlatformTransactionManager delegate;

    public MyTransactionManager(PlatformTransactionManager delegate) {
        this.delegate = delegate;
    }

    @Override
    public void commit(TransactionStatus status) {
        delegate.commit(status);
    }

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) {
        if (Thread.getCurrentThread() == /*something*/) {
            return delegate.getTransaction(definition);
        }
        else {
            throw new RuntimeException();
        }
    }

    @Override
    public void rollback(TransactionStatus status) {
        delegate.rollback(status);
    }
}
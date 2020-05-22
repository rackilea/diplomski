public class AutoCommitConnect implements Connect {
    private final Connect connect;
    private boolean transactional = false;
    private boolean committed = false;

    public AutoCommitConnect(Connect delegate) {
        this.delegate = delegate;
    }

    public void commit() {
        delegate.commit();
        committed = true;
    }

    public void setTransactional() {
        transactional = true;
        delegate.setTransactional();
    }

    public void close() {
        if (transactional && !committed) {
            commit();
        }
        delegate.close();
    }

    public void executeCommand() {
        delegate.executeCommand();
    }
}
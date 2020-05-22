class DummyReadLock extends ReentrantReadWriteLock.ReadLock {

    private ReentrantReadWriteLock.ReadLock readLock;

    // inherited constructor
    protected DummyRLock(ReentrantReadWriteLock rwlock) {
        super(rwlock);
        this.readLock = rwlock.readLock(); 
    }

    public ReentrantReadWriteLock.ReadLock readLock() {
        return readLock;
    }       
}
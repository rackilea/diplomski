...
    private ReentrantLock lock;
    private Condition isZero;

    public SimpleSemaphore (int permits, boolean fair) { 
        mPermits = permits;
        lock = new ReentrantLock(fair);
        isZero = lock.newCondition();
    }
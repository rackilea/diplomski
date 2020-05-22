class Testing implements Runnable {
    private final Lock lock;

    // pass in the lock to use via the constructor
    // both threads need to receive the same lock
    Testing(Lock lock){ this.lock = lock; }           

    public void run() {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            Tester.incrementCount();
            lock.unlock();
        }
    }
}
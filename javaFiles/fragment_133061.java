ReadWriteLock fooLock = new ReentrantReadWriteLock();
Lock fooReadLock = fooLock.readLock();
Lock fooWriteLock = fooLock.writeLock();

public void n() throws InterruptedException {
    fooWriteLock.lock();
    try {
        doFoo();
    } finally {
        fooWriteLock.unlock();
    }
}
private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
private final Lock readLock = readWriteLock.readLock();
private final Lock writeLock = readWriteLock.writeLock();
...
private void functionA() {
    readLock.lock();
    try {
       // do the A processing here ...
    } finally {
       readLock.unlock();
    }
}
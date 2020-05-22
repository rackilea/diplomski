private final ReadWriteLock lock = new ReentrantReadWriteLock();

private void read()
{
    lock.readLock().lock();
    try {
        ...
    } finally {
        lock.readLock().unlock();
    }
}

private void write()
{
    lock.writeLock().lock();
    try {
        ...
    } finally {
        lock.writeLock().unlock();
    }
}
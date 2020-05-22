private final ReadWriteLock lock = new ReentrantReadWriteLock();

private void slave()
{
    lock.readLock().lock();
    try {
        System.out.println(counter);
        ...
    } finally {
        lock.readLock().unlock();
    }
}

private void master()
{
    lock.writeLock().lock();
    try {
        counter ++;
        ...
    } finally {
        lock.writeLock().unlock();
    }
}
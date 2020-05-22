lock.writeLock().lock();
try {
    // method code
} finally {
    lock.writeLock().unlock();
}
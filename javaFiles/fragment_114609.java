rwlock.readLock().lock();
try {
    // do stuff
} finally {
    rwlock.readLock().unlock();
}
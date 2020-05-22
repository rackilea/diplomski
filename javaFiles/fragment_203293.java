lock.readLock().lock();
try {        
    // method code
} finally {
    lock.readLock().unlock();
}
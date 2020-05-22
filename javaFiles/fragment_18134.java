lock.writeLock().lock();
try{
    // Do your stuff here
} finally{
    lock.writeLock().unlock();
}
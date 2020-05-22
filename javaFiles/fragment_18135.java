lock.readLock().lock();
try{
    // Do your stuff here
} finally{
    lock.readLock().unlock();
}
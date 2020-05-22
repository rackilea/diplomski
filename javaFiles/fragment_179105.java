readLock.lock();
try {
   // read from map
} finally {
   readLock.unlock();
}

writeLock.lock();
try {
   // modify map
} finally {
   writeLock.unlock();
}
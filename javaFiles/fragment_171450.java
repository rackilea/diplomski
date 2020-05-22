final int holdCount = lock.getReadHoldCount();
for (int i = 0; i &lt; holdCount; i++) {
   lock.readLock().unlock();
}
lock.writeLock().lock();
try {
   // Perform modifications
} finally {
   // Downgrade by reacquiring read lock before releasing write lock
   for (int i = 0; i &lt; holdCount; i++) {
      lock.readLock().lock();
   }
   lock.writeLock().unlock();
}
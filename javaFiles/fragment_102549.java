T1:

while(...) {
  Lock readlock = readWriteLock.readLock();
  readlock.lock();

  doWork();

  readlock.unlock();  
}
while(...) {
  doWork();

  Lock writelock= readWriteLock.writeLock();
  writelock.lock();

  update();

  writelock.unlock();
}
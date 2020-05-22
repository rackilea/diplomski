private Lock lock = ...;

private boolean acquireLock() {
  if (lock.tryLock()) {
      ...
      return true;
  } else {
      return false;
  }
}
_prioLock.lock();
try {
  // ... use resource here ...
} finally {
  _prioLock.unlock();
}
_prioLock.lockPriority();
try {
  // ... use resource here ...
} finally {
  _prioLock.unlock();
}
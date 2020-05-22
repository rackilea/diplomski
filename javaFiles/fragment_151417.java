StampedLock lock;

void C() {
    long stamp = lock.tryWriteLock(1, TimeUnit.SECONDS);
    doWork();
    lock.unlockWrite(stamp);
}

void someTask() {
    long stamp = lock.readLock();
    doTask().thenRun(() -> lock.unlockRead(stamp));
}
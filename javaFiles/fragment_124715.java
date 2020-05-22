boolean hasPermit = false;
try {
    hasPermit = semaphore.tryAcquire();
    if (hasPermit) {
        // do stuff.
    }
} finally {
    if (hasPermit) {
       semaphore.release();
    }
}
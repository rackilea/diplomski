lock.acquire(permits);

try {
    // do some stuff here
} finally {
    lock.release(permits);
}
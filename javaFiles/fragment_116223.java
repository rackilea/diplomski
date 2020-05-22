try {
    lock.acquire(permits);

    try {
        // do some stuff here
    } finally {
        lock.release(permits);
    }
} catch(final InterruptedException ie) {
    // handle acquire failure here
}
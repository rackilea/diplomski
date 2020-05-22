public void o() throws InterruptedException {
    while (!fooWriteLock.tryLock()) {
        reticulateSpines();
    }
    try {
        doFoo();
    } finally {
        fooWriteLock.unlock();
    }
}
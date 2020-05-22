public void handle(Key key) throws InterruptedException {
    CountDownLatch latch = new CountDownLatch(1);

    // try to acquire the lock by inserting our latch as a
    // mapping for key        
    while(true) {
        CountDownLatch existing = lockMap.putIfAbsent(key, latch);
        if (existing != null) {
            // there is an existing key, wait on it
            existing.await();
        } else {
            break;
        }
    }

    try {
        externalSystem.process(key);
    } finally {
        lockMap.remove(key);
        latch.countDown();
    }
}
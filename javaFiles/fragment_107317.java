Thread t1 = new Thread(() -> {
    try {
        prod.test();
    } catch (InterruptedException e) {
        // handle: log or throw in a wrapped RuntimeException
        throw new RuntimeException("InterruptedException caught in lambda", e);
    }
});
AtomicBoolean flag = new AtomicBoolean();

methodA() {
    ...
    if (flag.compareAndSet(false, true)) {
        // execute in another thread / executor
        new Thread(() -> {
            try {
                doSomething();
            } finally {
                // unlock within the executing thread
                // calling thread can continue immediately
                flag.set(false);
            }
        }).start();
    }
    ...
}
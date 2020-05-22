private final static Object lock = new Object();

private static CompletableFuture<Boolean> pseudoAsyncCall(int input) {
    return CompletableFuture.supplyAsync(() -> {
                synchronized (lock) {
                    System.out.println("Executing for " + input);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return input > 3;
                }
            });
}
public static void main(String[] args) {
    Counter contador = new Counter(0);
    ExecutorService executor = Executors.newFixedThreadPool(10);
    for(int i = 0; i < 1000; i++) {
        executor.submit(() -> {
            contador.increment();
        });
    }
    executor.shutdown();
    try {
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
    }
    System.out.println(contador.getValue());
}
ExecutorService executorService = Executors.newFixedThreadPool(10);

executorService.execute(new Runnable() {
    public void run() {
        System.out.println("Asynchronous task");
    }
});

// alternative Java 8 lambda syntax:
executorService.execute(() -> System.out.println("Asynchronous task"));

executorService.shutdown();
public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();

    for (int i = 0; i < 1000; i++) {
        int e = i;
        executor.submit(new Callable<String>() {
            public String call() throws Exception {
                System.out.println("Executing " + e);
                count++;
                return "Incremented";
            }
        });
    }
    executor.shutdown();
    System.out.println("Count: " + count);
}
public Example(String url1, String url2) {
    // Create executorService.
    ExecutorService executorService = Executors.newWorkStealingPool();

    // Submit both tasks to executorService.
    Future<Integer> future1 = executorService.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return Parser.getPrice(url1);
        }
    });
    Future<Integer> future2 = executorService.submit(new Callable<Integer>() {
        @Override
        public Integer call() throws Exception {
            return Parser.getPrice(url2);
        }
    });

    // Shutdown executorService. (It will no longer accept tasks, but will complete the ones in progress.)
    executorService.shutdown();

    // Handle results of the tasks.
    try {
        // Note: get() will block until the task is complete
        field1 = future1.get();
        field2 = future2.get();
    } catch (InterruptedException e) {
        // TODO Handle it
    } catch (ExecutionException e) {
        // TODO Handle it
    }
}
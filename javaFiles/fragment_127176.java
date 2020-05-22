public void executeTasks(Callable<?>... tasks) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(tasks.length);
    for(Callable<?> task : tasks) {
        executorService.submit(task);
    }

    executorService.shutdown();
    executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
}
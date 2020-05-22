public static void main(String[] args) throws InterruptedException, ExecutionException {
    final Phaser phaser = new Phaser();
    final ExecutorService executor = Executors.newCachedThreadPool();
    Workflow workflow = new Workflow(executor, phaser);

    phaser.register();
    for (int request=0 ; request<10 ; request++) {
        workflow.execute(request);
    }

    phaser.arriveAndAwaitAdvance();
    executor.shutdown();
    executor.awaitTermination(30, TimeUnit.SECONDS);    
}
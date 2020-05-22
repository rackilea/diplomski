@Test
public void testFixedThreadPool() throws InterruptedException, ExecutionException {
    ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    CompletionService<Integer> ecs = new ExecutorCompletionService<Integer>(exec);

    // submit NUM_TASKS tasks
    for (int i = 0; i < NUM_TASKS; i++) {
        ecs.submit(this::task);
    }

    // now wait for all tasks
    int sum = 0;
    for (int i = 0; i < NUM_TASKS; i++) {
        sum += ecs.take().get();
    }

    Assert.assertEquals(NUM_TASKS, sum);
}
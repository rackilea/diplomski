@Test
public void testFutureTask() throws InterruptedException, ExecutionException {
    List<RunnableFuture<Integer>> taskList = new ArrayList<RunnableFuture<Integer>>();

    // run NUM_TASKS FutureTasks in NUM_TASKS threads
    for (int i = 0; i < NUM_TASKS; i++) {
        RunnableFuture<Integer> rf = new FutureTask<Integer>(this::task);
        taskList.add(rf);
        new Thread(rf).start();
    }

    // now wait for all tasks
    int sum = 0;
    for (Future<Integer> future : taskList) {
        sum += future.get();
    }

    Assert.assertEquals(NUM_TASKS, sum);
}
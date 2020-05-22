// Submit Task 1
CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
    }
    System.out.println("Task 1 completed");
    return 5;
});
// Submit Task 2
CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> {
    try {
        Thread.sleep(3000);
    } catch (InterruptedException e) {
    }
    System.out.println("Task 2 completed");
    return 7;
});
// This call will create a future that will wait for f1 and f2 to complete
// and then execute the runnable
CompletableFuture.allOf(f1, f2).thenRun(() -> {
    System.out.println("Both completed");
});
static final AtomicInteger STOP = new AtomicInteger(2);
static boolean shouldStop() {
    return STOP.getAndDecrement() <= 0;
}
static final int N = 10;
public static void main(String[] args) {
    Set<Integer> elements = IntStream.range(0, 100).boxed().collect(Collectors.toSet());
    ExecutorService executor = Executors.newFixedThreadPool(N);
    try {
        CompletableFuture<?> cancelAll = new CompletableFuture<>();
        CompletableFuture<?>[] all = elements.stream()
            .map(e ->
                CompletableFuture.runAsync(() -> {
                    System.out.println("entered "+e);
                    if(shouldStop()) {
                        RuntimeException myException = new RuntimeException("stopped");
                         // alternatively cancelAll.cancel(false);
                        cancelAll.completeExceptionally(myException);
                        throw myException;
                    }
                    System.out.println("processing "+e);
                }, executor))
            .toArray(CompletableFuture<?>[]::new);
        cancelAll.whenComplete((value,throwable) -> {
            if(throwable != null) {
                for(CompletableFuture<?> cf: all) cf.completeExceptionally(throwable);
            }
        });
        CompletableFuture.allOf(all).join();
    } catch (CompletionException e) {
        e.printStackTrace();
    }
    executor.shutdown();
}
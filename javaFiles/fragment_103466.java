Runnable r1 = () -> { ... };
// other Runnables

final Future<?> f1 = executorService.submit(r1);
// other Futures

try {
    f1.get();
    // other gets
} catch (ExecutionException e) { ... }
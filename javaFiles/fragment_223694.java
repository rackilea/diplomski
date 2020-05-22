public class Counter implements Callable<Void> {

    public static void main(String[] args) throws InterruptedException {
        final Map<String, Counter> map = new HashMap<>();
        map.put("", new Counter());
        final Map<String, Future<Void>> result = executeTasksInParallel(map);
        final Future<Void> voidFuture = result.get("");
        try {
            if (voidFuture.isDone()) {
                voidFuture.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Void call() throws Exception {
        for (long i = 0L; i < Long.MAX_VALUE; i++) {
            if (Thread.currentThread().isInterrupted()) {
                Thread.currentThread().interrupt(); // restore interrupted flag
                return null;
            }
            /* or e.g. throw an exception */
        }
        return null;
    }

    public static <K, V> Map<K, Future<V>> executeTasksInParallel(
            final Map<K, ? extends Callable<V>> callablesById)
            throws InterruptedException {
        final Map<K, Future<V>> resultFuturesById = new HashMap<>();
        final ExecutorService executorService =
            Executors.newFixedThreadPool(callablesById.size());
        for (final Map.Entry<K, ? extends Callable<V>> callableByIdEntry : callablesById
            .entrySet()) {
            final K id = callableByIdEntry.getKey();
            final Callable<V> callable = callableByIdEntry.getValue();
            final Future<V> resultFuture = executorService.submit(callable);
            resultFuturesById.put(id, resultFuture);
        }
        executorService.shutdown();
        executorService.awaitTermination(5L, TimeUnit.SECONDS);
        executorService.shutdownNow();
        return resultFuturesById;
    }
}
List<Future<?>> futures = new ArrayList<>();
for (Callable<?> callable : tasks) {
     futures.add(executor.submit(callable));
}
for (Future<?> future : futures) {
    future.get();
}
final ExecutorService pool = Executors.newFixedThreadPool(2);
final CompletionService<String> service = new ExecutorCompletionService<String>(pool);
final List<? extends Callable<String>> callables = Arrays.asList(
    new SleepingCallable("slow", 5000),
    new SleepingCallable("quick", 500));
for (final Callable<String> callable : callables) {
  service.submit(callable);
}
pool.shutdown();
try {
  while (!pool.isTerminated()) {
    final Future<String> future = service.take();
    System.out.println(future.get());
  }
} catch (ExecutionException | InterruptedException ex) { }
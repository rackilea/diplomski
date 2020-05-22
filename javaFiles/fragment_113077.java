final ExecutorService pool = Executors.newFixedThreadPool(2);
final List<? extends Callable<String>> callables = Arrays.asList(
    new SleepingCallable("quick", 500),
    new SleepingCallable("slow", 5000));
try {
  for (final Future<String> future : pool.invokeAll(callables)) {
    System.out.println(future.get());
  }
} catch (ExecutionException | InterruptedException ex) { }
pool.shutdown();
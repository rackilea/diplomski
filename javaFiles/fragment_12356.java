ExecutorService executorService = Executors.newSingleThreadExecutor();

// Callable that has a run() method that executes the task
Callable<String> callable = ...;

// Submit the task for execution
Future<String> future = executorService.submit(callable);

try {
    String result = future.get(30, TimeUnit.SECONDS);
    System.out.println("Result: " + result);
}
catch (TimeoutException e) {
    System.out.println("Timeout");
    future.cancel(true);
}
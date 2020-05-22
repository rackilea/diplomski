ExecutorService executor = Executors.newSingleThreadExecutor();
Future<String> task = executor.submit(new Task());
String str;
try {
  str = task.get(5, TimeUnit.SECONDS);
} finally {
  task.cancel(true);
}
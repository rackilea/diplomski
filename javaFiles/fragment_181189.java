Executor executor = Executors.newCachedThreadPool();
CompletionService<String> ecs = new ExecutorCompletionService<String>(executor);
List<Future<String>> futures = new ArrayList<Future<String>>();
try {
   futures.add(ecs.submit(search1));
   futures.add(ecs.submit(search2));

   for (int i = 0; i < futures.size(); ++i) {
     String result = ecs.take().get();
     if (result != null) {
       return result;
     }
   }
} finally {
  for (Future<String> f : futures) {
     f.cancel(true);
  }
}
executor.shutdownNow();
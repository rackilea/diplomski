ExecutorService es = Executors.newFixedThreadPool(
      Runtime.getRuntime().availableProcessors);

// to add a number of tasks
for(int i=0; i<numberOfTasks; i++) {
   es.submit(new Callable<ResultType>() {
      public ResultType call() {
          return doWork(i);
      }
   }
}
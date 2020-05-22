public void doGet(HttpServletRequest request, HttpServletResponse response) {
   // Creating a new ExecutorService for illustrative purposes.
   // As mentioned in comments, it is better to create a global 
   // instance of ExecutorService and use it in all servlets. 
   ExecutorService executor = Executors.newFixedThreadPool(2);

   Future<Result1> f1 = executor.submit(new Callable<Result1>() {
      @Override
       public Result1 call() throws Exception {
          // do expensive stuff here.
          return result;
      }
   });

   Future<Result2> f2 = executor.submit(new Callable<Result2>() {
      @Override
      public Result2 call() throws Exception {
         // do expensive stuff here.
         return result;
      }
   });

   // shutdown allows the executor to clean up its threads. 
   // Also prevents more Callables/Runnables from being submitted.
   executor.shutdown();

   // The call to .get() will block until the executor has
   // completed executing the Callable.
   Result1 r1 = f1.get();
   Result2 r2 = f2.get();
   MyResult result = new MyResult();
   // add r1 and r2 to result.
   // modify response based on result
}
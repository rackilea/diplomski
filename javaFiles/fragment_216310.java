private static final ExecutorService THREADPOOL
       = Executors.newCachedThreadPool();

private static <T> T call(Callable<T> c, long timeout, TimeUnit
timeUnit)
       throws InterruptedException, ExecutionException, TimeoutException
   {
       FutureTask<T> t = new FutureTask<T>(c);
       THREADPOOL.execute(t);
       return t.get(timeout, timeUnit);
   }

   try {
       String task = call(new Callable<String>() {
           public String call() throws Exception
           {
              String result = null
              do {
                  SendData()
              } while(result == null);          
            }, 2, TimeUnit.SECONDS);
   } catch (TimeoutException e) {
       System.err.println("Job timedout");
   }
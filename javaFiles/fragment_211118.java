public void test() throws InterruptedException, ExecutionException {

  Callable<String> myCall = new Callable<String>(){
    public String call() throws Exception{
      return doDomething();
    }
  };


  Callable<String> myCall2 = new Callable<String>(){
    public String call() throws Exception{
      return doDomething2();
   }
  };

  ExecutorService executor = Executors.newFixedThreadPool(2);
  List<Callable<String>> list = Arrays.asList(myCall, myCall2);
  List<Future<String>> futuresList = executor.invokeAll(list);

  String result1 = futuresList.get(0).get();
  String result2 = futuresList.get(1).get();

  executor.shutdown();
}
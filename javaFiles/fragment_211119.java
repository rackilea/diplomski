public void test() throws Exception {

  ExecutorService executor = Executors.newFixedThreadPool(2);
  List<Callable<String>> list = getList();
  List<Future<String>> futuresList = executor.invokeAll(list);

  String result1 = futuresList.get(0).get();
  String result2 = futuresList.get(1).get();

  System.out.println(result1);
  System.out.println(result2);

  executor.shutdown();
}

private <T> List<Callable<T>> getList() {

  Callable<T> myCall = new Callable<T>(){
    public T call() throws Exception{
      return (T) "a"; //doDomething();
    }
  };

  Callable<T> myCall2 = new Callable<T>(){
    public T call() throws Exception{
      return (T) "b"; //doDomething2();
    }
  };

  return Arrays.asList(myCall, myCall2);
}
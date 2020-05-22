public void kickOffAsyncTask() throws InterruptedException {
  Future<String> futureResult =  asyncTask.call();

  //do some stuff in parallel

  String result = futureResult.get();
  System.out.println(result);
}
ExecutorService es = Executors.newFixedThreadPool(2);
Callable<Void>[] calls = new Callable[2];
//... your other code here...
if (running && offset >= 0) {   
  final int finalOffset = offset;
  Callable<Void> call1 = new Callable<Void>()
  {
    @Override
    public Void call() throws Exception
    {
      dataLine.write(buffer, 0, finalOffset);
      return null;
    }
  };

  Callable<Void> call2 = new Callable<Void>()
  {
    @Override
    public Void call() throws Exception
    {
       fos.write(buffer);  // or however you need to write.
       return null;
    }
   };

   calls[0] = call1;
   calls[1] = call2;
   List<Callable<Void>> asList = Arrays.asList(calls);
   es.invokeAll(asList);  // invokeAll will block until both callables have completed.
}
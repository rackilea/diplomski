public String request() throws ExecutionException, InterruptedException {
   Foo foo = new Foo();
   FutureTask<String> fooFuture = new FutureTask<String>(foo);
   new Thread(fooFuture).start();
   return fooFuture.get();
}
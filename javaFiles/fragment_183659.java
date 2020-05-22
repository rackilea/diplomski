ExecutorService es = Executors.new (pick a thread pool of your choice)

// in thread A
es.execute(new Runnable() {
   public void run() {
      // task to run on Thread B
   }
});

// in thread A
Future<Type> future = es.submit(new Callable<Type>() {
   public Type call() {
      // task to run on Thread B and ...
      return type;
   }
});

// later get the result
Type t = future.get();
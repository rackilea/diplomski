// the lambda here must be a Callable as it returns an Integer
int result = executor.submit(() -> return 2);

// the lambda here must be a Runnable as it returns nothing
executors.submit(() -> System.out.println("Hello World"));

// the lambda here must be a Callable as an exception could be thrown
executor.submit(() -> {
   try (FileWriter out = new FileWriter("out.txt")) {
      out.write("Hello World\n");
   }
   return null; // Callable has to return something
});
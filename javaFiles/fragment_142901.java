ExecutorService executorService = Executors.newFixedThreadPool(4); // TODO: proper number of threads

Future<Integer> future1 = executorService.submit(() -> callService1()); // TODO: proper type and method
Future<String> future2 = executorService.submit(() -> callService2()); // TODO: proper type and method

executorService.shutdown();
executorService.awaitTermination(5, TimeUnit.MINUTES); // TODO: proper timeout

Integer result1 = future1.get(); // TODO: proper type
String result2 = future2.get(); // TODO: proper type
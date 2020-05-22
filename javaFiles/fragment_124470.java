ExecutorService executorService = Executors.newFixedThreadPool(5);
List<Future> futures = executorService.invokeAll(listOfCallables);
for (Future future : futures) {
   //do something with future.get();
}
executorService.shutdown();
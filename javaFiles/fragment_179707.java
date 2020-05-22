ExecutorService executorService = Executors.newFixedThreadPool(2);
for (int i = 0; i < totalResources; ++i) {
     executorService.submit(new ResourceProcessor(i));
}
// shutdown the thread pool after the last submit
executorService.shutdown();
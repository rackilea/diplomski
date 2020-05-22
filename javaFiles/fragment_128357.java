Executor e = Executors.newFixedThreadPool(4);
CompletionService<String> service = new ExecutorCompletionService<String>(e);
CountDownLatch startLatch = new CountDownLatch(1);
for (int i=0; i<numberOfResources; i++) {
     Resource r = createResource(startLatch, i);
     service.submit(r);
}
startLatch.countDown();
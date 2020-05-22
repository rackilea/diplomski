final ExecutorService executorService = Executors.newCachedThreadPool();
final ExecutorCompletionService<String> completionService = 
            new ExecutorCompletionService<String>(executorService);
for (int i = 0; i < 10; ++i) {
    completionService.submit(new Task());
}
completionService.take().get();
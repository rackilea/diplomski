public static void main(String[] args) throws Exception {
    final ExecutorService executorService = Executors.newFixedThreadPool(10);
    final ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);
    executorService.submit(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; ++i) {
                try {
                    final Future<String> myValue = completionService.take();
                    //do stuff with the Future
                    final String result = myValue.get();
                    System.out.println(result);
                } catch (InterruptedException ex) {
                    return;
                } catch (ExecutionException ex) {
                    System.err.println("TASK FAILED");
                }
            }
        }
    });
    for (int i = 0; i < 100; ++i) {
        completionService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                if (Math.random() > 0.5) {
                    throw new RuntimeException("FAILED");
                }
                return "SUCCESS";
            }
        });
    }
    executorService.shutdown();
}
public class FirstDoneWithCompletionServiceEx {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int jobs = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(jobs);
        CompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < jobs; i++)
            completionService.submit(
                    new Callable<Object>() {
                        @Override
                        public Object call() throws Exception {
                            //computation
                            return new Object();
                        }
                    }
            );

        //get first job done
        Object firstDone = completionService.take().get();

        executorService.shutdownNow();
    }
}
public static void main(String[] args) throws Exception {
        Callable<String> jobA = () -> {
            Thread.sleep(2000);
            return "JobA's result";
        };

        Callable<String> jobB = () -> {
            Thread.sleep(1000);
            return "JobB's result";
        };

        Executor executor = Executors.newFixedThreadPool(2);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executor);
        completionService.submit(jobA);
        completionService.submit(jobB);


        Future<String> futureWhichCompletedFirst = completionService.take();
        System.out.println(futureWhichCompletedFirst.get());

        Future<String> futureWhichCompletedNext = completionService.take();
        System.out.println(futureWhichCompletedNext.get());
    }
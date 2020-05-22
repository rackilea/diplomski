final ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
    Runnable tweetAnalyzer = defineMonitoringRunnable(tweetRepository);
    for (int i = 0; i < NUM_THREADS; i++) {
        executor.execute(tweetAnalyzer);
        try {
            Thread.sleep(THREADS_DELAY);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
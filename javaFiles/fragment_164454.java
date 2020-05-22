private ScheduledExecutorService executorService = null;

public void start() {
    if (executorService != null && !executorService.isShutdown()) return;

    executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Algorithm alg = new Algorithm(signal);
                alg.run();
                updateInterface();
            }
        }, 0, 60, TimeUnit.MILLISECONDS);
}

public void stop() {
    if (executorService != null)
        executorService.shutdown();
}
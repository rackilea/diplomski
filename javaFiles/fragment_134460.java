final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
executorService.scheduleWithFixedDelay(new Runnable() {
    @Override
    public void run() {
         //Do you database save here
    }
}, 0, 15, TimeUnit.MINUTES);
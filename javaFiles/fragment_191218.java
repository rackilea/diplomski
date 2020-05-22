ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
scheduledExecutor.schedule(new Runnable() {
    @Override
    public void run() {
        /*
        send email
        */
    }
}, n, TimeUnit.MINUTES);
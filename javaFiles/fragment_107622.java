ScheduledExecutorService executor = Executors.newScheduledThreadPool(NUMBER_OF_THREADS);
executor.scheduleAtFixedRate(new Runnable() {

    @Override
    public void run() {
        // runnable logic           
    }
}, 0, 1, TimeUnit.SECONDS);
Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        es.shutdown();
        try {
            es.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.info("during await",e);
        }
    }
});
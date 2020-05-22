Executors.newFixedThreadPool(1, new ThreadFactory() {
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r) {
            @Override
            public void interrupt() {
                // do what you need
            }
        };
    }
});
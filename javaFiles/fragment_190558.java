ExecutorService service = Executors.newSingleThreadExecutor(new ThreadFactory() {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "worker");
        t.setDaemon(true);
        return t;
    }
});

service.submit(new Runnable() { /* task for this thread to perform */ });

service.shutdown(); // to stop it.
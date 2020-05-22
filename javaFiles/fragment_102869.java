public static void alienMethod() throws InterruptedException{
    ExecutorService es = Executors.newSingleThreadExecutor();
    es.submit(new Runnable() {
        @Override
        public void run() {
            modifyLines();
        }
    });
    es.shutdown();
    es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
}
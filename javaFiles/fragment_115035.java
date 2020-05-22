ExecutorService es = Executors.newSingleThreadExecutor();
Future f = es.submit(new Runnable() {
    @Override
    public void run() {
        long start = System.nanoTime();
        while(!Thread.interrupted()) {
            // busy wait.
        }
        long time = System.nanoTime() - start;
        System.out.printf("Finished task after %,d ns%n", time);
    }
});
try {
    f.get(1, TimeUnit.SECONDS); // stops if the task completes.
} catch (TimeoutException e) {
    f.cancel(true);
}
es.shutdown();
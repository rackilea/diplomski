public static void main(String... args) {
    ExecutorService es = Executors.newFixedThreadPool(2);
    for (int i = 0; i < 1000 * 1000; i++)
        es.submit(new SleepOneSecond());

    System.out.println("Queue length " + ((ThreadPoolExecutor) es).getQueue().size());
    es.shutdown();
    System.out.println("After shutdown");
    try {
        es.submit(new SleepOneSecond());
    } catch (Exception e) {
        e.printStackTrace(System.out);
    }
}

static class SleepOneSecond implements Callable<Void> {
    @Override
    public Void call() throws Exception {
        Thread.sleep(1000);
        return null;
    }
}
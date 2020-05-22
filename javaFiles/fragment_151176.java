public static void main(String[] args) throws TimeoutException {
    final ExecutorService pool = Executors.newFixedThreadPool(10);
    runWithRetry(pool, 5);  //run here
}

public static void runWithRetry(final ExecutorService pool, final int retries) throws TimeoutException {
        final Future<?> result = pool.submit(new Runnable() {
            @Override
            public void run() {
                Motor.A.rotate(angle);
            }
        });
        try {
            result.get(1, TimeUnit.SECONDS);  //wait here
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getCause());
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } catch (TimeoutException e) {
            if (retries > 1) {
                runWithRetry(pool, retries - 1);  //retry here
            } else {
                throw e;
        }
    }
}
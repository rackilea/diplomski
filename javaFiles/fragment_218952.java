public class RetryExecutor extends ThreadPoolExecutor {

    private final long maxRetries;
    private Map<Runnable, Integer> retries = new ConcurrentHashMap<>();

    public RetryExecutor(int corePoolSize, int maximumPoolSize, long maxRetries,
                     long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.maxRetries = maxRetries;
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null && shouldRetry(r)) {
            retry(r);
        }  else if (t == null && r instanceof Future<?>) {
            try {
                ((Future<?>) r).get();
            } catch (CancellationException | ExecutionException e) {
                // you should log the error
                if (shouldRetry(r)) {
                    retry(r);
                } else {
                    retries.remove(r);
                }
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt(); // ignore/reset or catch it to reschedule
            }
        } else {
            retries.remove(r);
        }
    }

    private boolean shouldRetry(Runnable r) {
        final Integer nbRetries = retries.getOrDefault(r, 0);
        return nbRetries < maxRetries;
    }

    private void retry(Runnable r) {
        final Integer nbRetries = retries.getOrDefault(r, 0);
        retries.put(r, nbRetries + 1);
        this.execute(r);
    }

}
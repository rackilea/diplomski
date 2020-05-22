public class TimedThreadPoolExecutor extends ThreadPoolExecutor {
    private Map<Thread, Long> threads = new HashMap<Thread, Long>();
    private Timer timer;

    public TimedThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
            long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue,
            long maxExecutionTime,
            long reaperInterval) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        startReaper(maxExecutionTime, reaperInterval);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        threads.remove(Thread.currentThread());
        System.out.println("after: " + Thread.currentThread().getName());
        super.afterExecute(r, t);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        System.out.println("before: " + t.getName());
        threads.put(t, System.currentTimeMillis());
    }

@Override
protected void terminated() {
    if (timer != null) {
        timer.cancel();
    }
    super.terminated();
}

    private void startReaper(final long maxExecutionTime, long reaperInterval) {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                // make a copy to avoid concurrency issues.
                List<Map.Entry<Thread, Long>> entries = 
                        new ArrayList<Map.Entry<Thread, Long>>(threads.entrySet());
                for (Map.Entry<Thread, Long> entry : entries) {
                    Thread thread = entry.getKey();
                    long start = entry.getValue();
                    if (System.currentTimeMillis() - start > maxExecutionTime) {
                        System.out.println("interrupting thread : " + thread.getName());
                        thread.interrupt();
                    }
                }
            }

        };
        timer.schedule(timerTask, reaperInterval, reaperInterval);
    }

    public static void main(String args[]) throws Exception {
        TimedThreadPoolExecutor executor = new TimedThreadPoolExecutor(5,5, 1000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(20),
                1000L,
                200L);

        for (int i=0;i<10;i++) {
            executor.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(5000L);
                    }
                    catch (InterruptedException e) {

                    }
                }
            });
        }

        executor.shutdown();
        while (! executor.isTerminated()) {
            executor.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        }
    }



}
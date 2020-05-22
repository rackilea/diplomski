final Queue<Task> tasks = new ConcurrentLinkedQueue<Task>();
int ratePerSecond = 10;
final ExecutorService es = Executors.newCachedThreadPool();
ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
ses.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        final Task task = tasks.poll();
        if (task == null) return;
        es.submit(new Runnable() {
            @Override
            public void run() {
                process(task);
            }
        });
    }
}, 0, 1000/ratePerSecond, TimeUnit.MILLISECONDS);
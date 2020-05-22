final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

final Runnable task = new Runnable() {
    public void run() {
        System.out.println("Would it run?"+System.currentTimeMillis());
    }
};
final ScheduledFuture<?> handle =
        scheduler.scheduleAtFixedRate(task, 2, 5, TimeUnit.SECONDS);
scheduler.schedule(new Runnable() {
    public void run() { handle.cancel(true); }
}, 60, SECONDS);
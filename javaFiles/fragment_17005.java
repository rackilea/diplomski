public class BeeperControl {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final AtomicInteger count = new AtomicInteger(0);

    public void beep() {
        final Runnable beeper = new Runnable() {
            public void run() {
                count.getAndIncrement();
                System.out.println("beep " + count);

                if (count.get() == 5) {
                    scheduler.shutdown();
                }
            }
        };
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(
                beeper, 1, 1, SECONDS);
    }

    public static void main(String[] args) {
        BeeperControl bc = new BeeperControl();
        bc.beep();
    }
}
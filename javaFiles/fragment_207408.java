ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

final Runnable beeper = new Runnable() {
    public void run() { System.out.println("beep"); }
};

// Beeps every 10 seconds
scheduler.scheduleAtFixedRate(beeper, 0, 10, TimeUnit.SECONDS);
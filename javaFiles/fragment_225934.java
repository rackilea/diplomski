int delay = 15; // adjust the delay

ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool();
scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
    public void run() {
        ball.move();
        player.move();
    }
}, delay, TimeUnit.MILLISECONDS)
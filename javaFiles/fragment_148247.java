Timer timer = new Timer("Download Timer");
timer.scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        executor.execute(new DownloadRunnable());
    }
}, 0, TIMER_DELAY);
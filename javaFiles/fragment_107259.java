class UpdateApplet() implements Runnable {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    volatile boolean running;
    int updateInterval = 1000;

    public void start() {
       scheduler.schedule(this, updateInterval, updateInterval, TimeUnit.MILLISECONDS);
    }

    public void run() {
         if(!running) {
             scheduler.shutdown();
         }
         else {
              repaint();
         }
    }
}
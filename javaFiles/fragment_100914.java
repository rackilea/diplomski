public class HourRun implements Runnable {
        private final ScheduledExecutorService scheduler 
                                  = Executors.newScheduledThreadPool(1);
        int period = 1;
        int delay = 0;
        TimeUnit timeUnit = TimeUnit.HOURS;
        ScheduledFuture scheduledFuture;

        public HourRun() {
         scheduledFuture = scheduler.scheduleAtFixedRate(this,
                    period, delay, timeUnit);
        }


        @Override
         public void run() {
            // This will be called every hour.
         }
    }
ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    Runnable task = new Runnable() {
        public void run() {
            //Your 'if' condition here
        }
    };

    int delay = 3; //delay 3 seconds, or whatever
    scheduler.schedule(task, delay, TimeUnit.SECONDS);
    scheduler.shutdown();
...
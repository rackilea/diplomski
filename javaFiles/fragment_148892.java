ScheduledFuture<?> f = Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
        public void run() {
            System.out.println("run");
        }
    }, 0, 10000, TimeUnit.MILLISECONDS);
    Thread.sleep(1000);
    System.out.println("Time left before next run " + f.getDelay(TimeUnit.MILLISECONDS));
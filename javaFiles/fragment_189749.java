class HiTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Say Hi!");
    } 
}

// periodically execute task in every 100 ms, without initial delay time

ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

long initialDelay = 0;
long period = 100;

ScheduledFuture<?> future1 = exec.scheduleAtFixedRate(new HiTask(), initialDelay, period, TimeUnit.MILLISECONDS);


// to trigger task execution immediately

boolean success = future.cancel(true);    // mayInterruptIfRunning = true: interrupt thread even task has already started

ScheduledFuture<?> future2 = exec.scheduleAtFixedRate(new HiTask(), initialDelay, period, TimeUnit.MILLISECONDS);
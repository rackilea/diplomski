Date desiredDate = // ...
Date now = new Date();
long delay = desiredDate.getTime() - now.getTime();

ScheduledExecutorService ses = Executors.newSingleThreadScheduledExecutor();
ses.schedule(new Runnable(){
    @Override
    public void run() {
        Programisrunning = false;
        // + do other things?
    }
}, delay, TimeUnit.MILLISECONDS); // run in "delay" millis
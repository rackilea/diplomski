ScheduledExecutorService exec = Executors.newScheduledThreadPool(1);

AtomicInteger i = new AtomicInteger(0);
exec.scheduleAtFixedRate(() -> {
    int j = i.getAndAdd(4);
    if (j >= 200) {
        exec.shutdownNow();
        return;
    }

    System.out.println(j); //Will print 0,4,8 etc.. Once every 5 seconds
    //Do stuff
}, 0, 5, TimeUnit.SECONDS);
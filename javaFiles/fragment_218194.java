ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

Runnable command = () -> {
    System.out.println("Yo");
    try {
        Thread.sleep(4000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
};

Runnable commandRunner = () -> {
    scheduledExecutorService.schedule(command, 0, TimeUnit.SECONDS);
}

scheduledExecutorService.scheduleAtFixedRate(commandRunner, 0, 1, TimeUnit.SECONDS);
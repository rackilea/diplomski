ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
Runnable task = () -> {
event.JDA().getPresence().setGame(Game.watching(event.getJDA().getGuilds().size() + "servers"));
};

executor.scheduleWithFixedDelay(task, 0, 20,TimeUnit.SECONDS);
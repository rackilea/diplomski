public static void main(String[] args) {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    executor.scheduleAtFixedRate(() -> {

    }, 0, 31250, TimeUnit.MICROSECONDS);
}
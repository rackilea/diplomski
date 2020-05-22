public static void updateIndex() {
        Runnable runnable = () -> {
            //Do your logic here
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.MINUTES);
        }
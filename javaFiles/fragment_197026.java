public class MyScheduler {

    private static ScheduledExecutorService service;

    private static MainTask mainTask;

    static {
        service = Executors.newSingleThreadScheduledExecutor();
        mainTask = MainTask.getInstance();
    }

    public static void execute() {
        service.scheduleAtFixedRate(mainTask, 0, 4, TimeUnit.SECONDS);

    }
}
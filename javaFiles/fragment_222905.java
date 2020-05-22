public class MessageTask implements Managed, Runnable {

    private static final Logger log = Logger.getLogger(MessageTask.class);

    private ScheduledExecutorService mainRunner = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("task-%d").build());

    // injected by DI or set programatically

    @Inject
    private long delay;

    @Inject
    private long period;


    @Override
    public void start() throws Exception {
        mainRunner.scheduleAtFixedRate(this, delay, period, TimeUnit.MILLISECONDS);
    }

    @Override
    public void stop() throws Exception {
        mainRunner.shutdown();
    }

    @Override
    public void run() {
        try {
            runInner();
        } catch (Exception e) {
            log.error("Error executing task", e);
        }
    }

    private void runInner() throws Exception {
        // do your timer task work here
    }

}
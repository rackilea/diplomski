static {
    Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
            Logger.getGlobal().info("destroying");
            exec.shutdownNow();
        }
    });
}

public static void main(String[] args) throws Exception {
    Future f = exec.schedule(new Runnable() {
        @Override
        public void run() {
            Logger.getGlobal().info("thread run");

        }
    }, 10, TimeUnit.SECONDS);
    while (!f.isDone()) {
        Logger.getGlobal().info("waiting for task to finish");
        Thread.sleep(1000);
    }
    Runtime.getRuntime().exit(0);
}
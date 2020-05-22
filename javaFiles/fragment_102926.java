final ExecutorService executor;

Runtime.getRuntime().addShutdownHook(new Thread() {
    public void run() {
        executor.shutdown();
        if (!executor.awaitTermination(SHUTDOWN_TIME)) { //optional *
            Logger.log("Executor did not terminate in the specified time."); //optional *
            List<Runnable> droppedTasks = executor.shutdownNow(); //optional **
            Logger.log("Executor was abruptly shut down. " + droppedTasks.size() + " tasks will not be executed."); //optional **
        }
    }
});
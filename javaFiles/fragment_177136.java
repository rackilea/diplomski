public class DataParseManager {
    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(300));

    public void addParseDataTask(String source, String dataType) {
        executor.execute(new MonitorRunnable(new GetDataTask(source, dataType)));
    }

    // here's the method that I need
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        //and here's the method that I'm missing - executor.getActiveThreads()
        synchronized (MonitorRunnable.activeTasks) {
            for (Runnable r : MonitorRunnable.activeTasks) {
                info.append(((GetDataTask) r).toString()).append('\n');
            }
        }
        return info.append(executor.toString()).toString();
   }
}
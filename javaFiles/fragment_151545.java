public class DataProcessor {
    final ExecutorService workerThreadPool = Executors.newFixedThreadPool(5);

    public void onNewDataFromTheOutsideWorld(Data d) { 
       workerThreadPool.execute(new ProcessingAndStoreToDBRunnable(d));
    }

    public void onShutdown() { 
       workerThreadPool.shutdown();
    }
}
SwingWorker worker = new SwingWorker() {
    @Override
    protected Object doInBackground() throws Exception {
        System.out.println("Starting");
        Thread.sleep(10000);
        System.out.println("Ending");
        return null;
    }
};
worker.execute();
synchronized (SwingWorker.class) {
    AppContext appContext = AppContext.getAppContext();
    ExecutorService executorService = (ExecutorService) appContext.get(SwingWorker.class);
    System.out.println(executorService);
    System.out.println("Shutting down");
    executorService.shutdownNow();
    try {
        System.out.println("Waiting");
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("Done");
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
    appContext.remove(SwingWorker.class);
}
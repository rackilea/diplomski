public class MyClass {

private ExecutorService executorService;

private boolean stopThread = false;

public void start() {
   // gives name to threads
    BasicThreadFactory factory = new BasicThreadFactory.Builder()
             .namingPattern("thread-%d").build();
    executorService =  Executors.newSingleThreadExecutor(factory);
    executorService.execute(new Runnable() {
        @Override
        public void run() {
            try {
                doTask();
            } catch (Exception e) {
                logger.error("indexing failed", e);
            }

        }
    });
    executorService.shutdown();
}

private void doTask()  {
    logger.info("start reindexing of my objects");
    List<MyObjects> listOfMyObjects = new MyClass().getMyObjects();
    for (MyObjects myObject : listOfMyObjects) {
        if(stopThread){ // this is important to stop further indexing
            return;
        }
        DbObject dbObjects = getDataFromDB();
        // do some task
    }
}



public void stop() {
    this.stopThread = true;
    if(executorService != null){
        try {
            // wait 1 second for closing all threads
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
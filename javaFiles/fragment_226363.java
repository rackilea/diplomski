ExecutorService executorService = Executors.newFixedThreadPool(10);

executorService.execute(new Runnable() {
public void run() {
    //Start your mock service
    }
});

executorService.shutdown();
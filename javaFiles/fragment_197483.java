ExecutorService executor = Executors.newCachedThreadPool();
ExecutorService monitor = Executors.newFixedThreadPool(99);

public void submit(Runnable task) {
    Runnable monitorTask = new Runnable() {
        @Override
        public void run() {
            Future<?> future = executor.submit(task);
            try {
                future.get(15, TimeUnit.MINUTES);
            } catch (InterruptedException e) {
                // retry waiting. iterative approach not shown here
            } catch (ExecutionException e) {
                // your task exploded
            } catch (TimeoutException e) {
                // your task timed out - perform clean up, eg
                future.cancel(true);
            }               
        }
    };
    monitor.submit(monitorTask);
}
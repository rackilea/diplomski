final ExecutorService threadPool = Executors.newFixedThreadPool(2);

for(int i = 0; i < 2; i++){
    final int taskNb = i;
    threadPool.submit(new Runnable() {
        public void run() {
            System.out.println("Thread " + taskNb + " start: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Submit same task again
            threadPool.submit(this);

        }
    });
}

// Only shutdown the pool after given amount of time
Thread.sleep(100_000_000);
threadPool.shutdown();

// Wait for running tasks to finish
threadPool.awaitTermination(5, TimeUnit.SECONDS);
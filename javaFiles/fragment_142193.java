int poolSize = 3;
int jobCount = 3;
Runnable r = new MyRunnable()
ExecutorService  pool = Executors.newFixedThreadPool(poolSize);
for (int i = 0; i < jobCount; i++) {
    pool.execute(r);
}
pool.shutdown();
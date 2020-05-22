// only allow 5 threads to do the expensive work at the same time
private final Semaphore semaphore = new Semaphore(5, true /* fairness */);
...
// this will block if there are already 5 folks doing the expensive work
semaphore.acquire();
try {
   doExpensiveWork();
} finally {
   // always do the release in a try/finally to ensure the permit gets released
   // even if it throws
   semaphore.release();
}
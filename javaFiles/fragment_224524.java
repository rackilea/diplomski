public static void main(String[] args) {
   int primeStart = 5;

   // Make thread-safe list for adding results to
   List list = Collections.synchronizedList(new ArrayList());

   // Pull thread pool count out into a value so you can easily change it
   int threadCount = 10000;
   Thread[] threads = new Thread[threadCount];

   // Start all threads
   for(int i = 0;i < threadCount;i++) {
     // Pass list to each Runnable here
     // Also, I added +i here as I think the intention is 
     //    to test 10000 possible numbers>5 for primeness - 
     //    was testing 5 in all loops
     PrimeRunnable pr = new PrimeRunnable(primeStart+i, list);
     Thread[i] threads = new Thread(pr);
     threads[i].start();  // thread is now running in parallel
   }

   // All threads now running in parallel

   // Then wait for all threads to complete
   for(int i=0; i<threadCount; i++) {
     threads[i].join();
   }
}
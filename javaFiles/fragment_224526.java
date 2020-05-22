public static void main(String[] args) {
   int primeStart = 5;

   // Make thread-safe list for adding results to
   List list = Collections.synchronizedList(new ArrayList());

   int threadCount = 16;  // Experiment with this to find best on your machine
   ExecutorService exec = Executors.newFixedThreadPool(threadCount);

   int workCount = 10000;  // See how # of work is now separate from # of threads?
   for(int i = 0;i < workCount;i++) {
     // submit work to the svc for execution across the thread pool 
     exec.execute(new PrimeRunnable(primeStart+i, list));
   }

   // Wait for all tasks to be done or timeout to go off
   exec.awaitTermination(1, TimeUnit.DAYS);
}
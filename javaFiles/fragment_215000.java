long start = System.nanoTime();
ExecutorService service = Executors.newWhatEverPool();
for(loop)
   service.submit(new MyRunnable());

service.shutdown();
service.awaitTermination(1, TimeUnit.HOUR); // or longer.    
long time = System.nanoTime() - start;
System.out.printf("Tasks took %.3f ms to run%n", time/1e6);
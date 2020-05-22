ExecutorService executor = Executors.newFixedThreadPool(20);
List<Future<?>> futures = new ArrayList<Future<?>>(1000);
for (int i = 0; i < 1000; i++) { 
   futures.add(executor.submit(new Runnable() {...}));
}
for (Future<?> f : futures) {
   f.get();
}
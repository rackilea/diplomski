final ValuableResultWrapper wrapper = new ValuableResultWrapper();
final CountDownLatch latch = new CountDownLatch(1);

Callable<ValuableResultWrapper> task = new Callable<>() { 
   ... 
   wrapper.setValue(...); // here we set what we have computed so far
   latch.countDown();
   return wrapper;
   ...  
};
Future<ValuableResultWrapper> future = Executors.newSingleThreadExecutor().submit(task);
try {
    return future.get(timeout, TimeUnit.SECONDS);
} catch (TimeoutException te) {
    future.cancel(true);
    // HERE! Get what was computed so far
    latch.await();
    return wrapper;
}
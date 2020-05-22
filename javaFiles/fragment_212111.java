ExecutorService es = Executors.newFixedThreadPool(1); // You only asked for 1 thread
Future<?> future = es.submit( new Mythread() );
try {
    future.get(timeout, TimeUnit.SECONDS); // This waits timeout seconds; returns null
} catch(TimeoutException e) {
    future.cancel(true);
}
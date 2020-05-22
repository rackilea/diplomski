ExecutorService executor = Executors.newSingleThreadExecutor();
Future<?> future = executor.submit(new Runnable() {

@Override
public void run() {
    search();
    }
});
try {
    future.get(2000, TimeUnit.SECONDS);
} catch (TimeoutException e) {
    // handle time expired
}
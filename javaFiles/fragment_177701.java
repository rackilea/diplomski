int threadPoolSize = 5;
ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);

public void receive(Alert a) {
    assert a != null;
    executor.submit(() -> {
        // Do your work here
    });
}
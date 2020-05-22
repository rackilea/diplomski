@Test
public void tet() {
    ScheduledExecutorService poolExecutor =
            new CustomExecutor(4);
    for (int i = 1; i <= 4; i++) {
        poolExecutor.scheduleAtFixedRate(new Task(i), 0, 1000, TimeUnit.MILLISECONDS);
    }
    try {
        poolExecutor.awaitTermination(10000, TimeUnit.MILLISECONDS);
    } catch (Exception e) {
    }
}
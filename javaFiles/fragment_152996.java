while (!Thread.currentThread().isInterrupted()) {
    // do something
    try {
        TimeUnit.SECONDS.sleep(1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        break;
    }
}
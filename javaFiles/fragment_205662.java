public static void waitAtLeast(long millis) {
    long startTime = System.nanoTime();
    while (true) {
        long now = System.nanoTime();
        long timeWaited = (now - startTime) / 1000000L;
        if (timeWaited > millis) {
            return;
        }
        try {
            Thread.sleep(millis - timeWaited);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
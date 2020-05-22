public static void trySleep(long millis) {
    try {
        Thread.sleep(millis);
    } catch (InterruptedException e) {
        throw new RuntimeException("Interrupted during sleep", e);
    }
}
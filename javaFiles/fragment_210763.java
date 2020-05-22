public static void waitForRunLater() throws InterruptedException {
    Semaphore semaphore = new Semaphore(0);
    Platform.runLater(() -> semaphore.release());
    semaphore.acquire();

}
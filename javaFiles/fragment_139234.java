private static final long MAX_RATE = 1000;
private static final Semaphore API_CALL_SEMAPHORE = new Semaphore(1);
private volatile long lastCall;

public void callApi() throws IOException, InterruptedException {
    try {
        API_CALL_SEMAPHORE.acquire();
        delayedCall();
    } catch (IOException | InterruptedException e) {
        throw e;
    } finally {
        API_CALL_SEMAPHORE.release();
    }
}

private void delayedCall() throws InterruptedException, IOException {
    long tryCallTime = System.currentTimeMillis();
    final long deltaTime = tryCallTime - lastCall;
    if (deltaTime < MAX_RATE){
        final long sleepTime = MAX_RATE - deltaTime;
        Thread.sleep(sleepTime);
        tryCallTime += sleepTime;
    }
    // API CALL
    lastCall = tryCallTime; // if you want to delay only succeed calls.
}
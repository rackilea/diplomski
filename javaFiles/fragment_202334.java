private class MyTask implements Runnable {
    public void run() {
        long threadId = Thread.currentThread().getId();
        logger.debug("Thread # " + threadId + " is doing this task");
    }
}
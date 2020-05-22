public void run() {
    long start = System.currentTimeMillis();
    while (shouldRun()) {
        doTask();
        long next = start + FIVE_MINUTES;
        try {
            Thread.sleep(next - System.currentTimeMillis());
            start = next;
        } catch (InterruptedException e) {
            . . .
        }
    }
}
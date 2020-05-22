long timeToWakeup = System.currentTimeMillis() + t.time;
long sleepMs = t.time;
while (sleepMs > 0) {
    try {
        Thread.sleep(sleepMs);
    } catch(InterruptedException exc) {
        System.out.println("End of thread.");
        return;
    }
    sleepMs = timeToWakeup - System.currentTimeMillis());
}
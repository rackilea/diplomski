@Override
public void run() {
    try {
        // This call will wait until the referee counts the latch down to zero
        referee.getStartLatch().await();
    } catch (InterruptedException e) {
        // Handle unexpected interruption here
    }
}
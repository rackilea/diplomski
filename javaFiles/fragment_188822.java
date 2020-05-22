// In MainApp
public void togglePauseResume() {
    synchronized (paused) {
        if (paused.get()) {
            paused.set(false);
            paused.notify();
        }
        else {
            paused.set(true); // You don't need compareAndSet() because paused object has been used for synchronization (i.e. locked)
        }
    }
}
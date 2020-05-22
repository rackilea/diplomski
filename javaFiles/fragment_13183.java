public void waitForResponse() {
    try {
        synchronized (LocalServerReceiver.this) {
            LocalServerReceiver.this.wait();
        }
    } catch (InterruptedException e) {
        // Should not happen
    }
}
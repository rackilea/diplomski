public void waitForInputs() throws InterruptedException {
    synchronized (this) {
        // Make the current thread waits until a notify or an interrupt
        wait();
    }
}
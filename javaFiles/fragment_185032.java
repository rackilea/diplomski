public void run() {
    for (int i = 0; i < MAX; i++) {
        synchronized (myCounter) {
            myCounter.increment();
            try {
                myCounter.wait(0L, 1);
                myCounter.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
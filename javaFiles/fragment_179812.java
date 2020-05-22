while (running) {
    synchronized (tickSignal) {
        try {
           tickSignal.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Code

        // Task finished
        int counter = completedThreadsCounter.incrementAndGet();
        if (counter == N-1) {
            // Notify Thread N when the first N-1 tasks are finished
            synchronized (finalThreadSignal) {
                finalThreadSignal.notify();
            }
            // Reset the finished Threads counter and wait for the next tick signal
            completedThreadsCounter.set(0);
        }
    }
}
while (running) {
    // Here we synchronize on the signal that will be given when 
    // the first N-1 Threads are finished
    synchronized (finalThreadSignal) {
        try {
            finalThreadSignal.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Execute final Thread code
    }
}
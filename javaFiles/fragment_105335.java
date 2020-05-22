public void run () {
    while (true) {
        doWork(); 
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            return;
        }
    }
}
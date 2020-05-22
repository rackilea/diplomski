class Thread1 extends Thread {
    public void run(){
        synchronized (ThreadCount.lockObj) {
            while (ThreadCount.counter < 1000) {
                ThreadCount.incrementCounter();
                ThreadCount.printCounter(this);

                try {
                    ThreadCount.lockObj.notifyAll();
                    ThreadCount.lockObj.wait();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
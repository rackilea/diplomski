class ThreadB implements Runnable {
    public final int val;
    public ThreadB(int val) { this.val = val; }

    @Override public void run() {
        try {
            //  synchronize outside the loop so we don't constantly lock/unlock
            synchronized (NThread.monitor) {
                while (true) { // spin until interrupted
                    while (NThread.baton != val) // handle spurious wake-ups
                        NThread.monitor.wait();
                    //  print, increment and notify
                    TestUtil.printNum(val);
                    NThread.baton = (NThread.baton + 1) % TestUtil.N;
                    NThread.monitor.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            // if interrupted then we exit
        }
    }
}
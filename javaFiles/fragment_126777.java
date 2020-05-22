class SyncObj {
    private boolean condition = false;
    private Object obj = new Object();

    public void doWait() {
        synchronized (obj) {
            while (!condition) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            condition = false;
        }
    }

    public void doNotify() {
        synchronized (obj) {
            condition = true;
            obj.notify();
        }
    }
}
public Worker implements Runnable {
    private int idOfMap = ...;
    @Override
    public void run() {
        Lock lock = getLock(idOfMap);
        try {
            lock.lock();
            // The work goes here
            //...
        } finally {
            lock.unlock();
        }
    }
}
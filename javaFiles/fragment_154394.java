final Lock lock = new ReentrantLock();
lock.lock();
Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
});
t.start();
Thread.sleep(100);
System.out.println(t + " is " + t.getState());
lock.unlock();
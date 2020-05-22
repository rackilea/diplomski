public static void main(String[] args) {
    ProgressWheel wheel = new ProgressWheel();
    CountDownLatch latch = new CountDownLatch(3);
    wheel.start();
    new WorkerThread(latch).start(); 
    new WorkerThread(latch).start();
    new WorkerThread(latch).start();
    try {
        latch.await(); //wait until counter reaches 0
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    wheel.stop();

}

private static class WorkerThread extends Thread{
    private CountDownLatch counter;
    public WorkerThread(CountDownLatch counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        //Do some heavy work
        counter.countDown(); //This thread is finished
    }
}
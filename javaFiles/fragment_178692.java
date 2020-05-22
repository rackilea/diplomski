@Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " completed.");
        latch.countDown();

    }
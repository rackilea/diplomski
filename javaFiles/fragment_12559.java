CountDownLatch startSignal = new CountDownLatch(1);
    CountDownLatch doneSignal = new CountDownLatch(5); // 5 tasks

    class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        private final int threadNumber;

        // you can pass additional arguments as well
        Worker(CountDownLatch startSignal, CountDownLatch doneSignal,
                                                   int threadNumber) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
            this.threadNumber = threadNumber;
        }

        public void run() {
            try {
                startSignal.await();
                doWork(); // actual work to be performed here    
                doneSignal.countDown();
            } catch (InterruptedException ex) {
                LOGGER.error(ex);
            }
        }
    }

    // 5 new threads are started
    for(int i=1;i<=5;i++){
        new Thread(new Worker(startSignal, doneSignal, i)).start();
    }

    startSignal.countDown(); // let all threads proceed
    try {
        doneSignal.await(); // wait for all to finish
        // all 5 tasks are finished and do whatever you want to do next
    } catch (InterruptedException interruptedException) {
        LOGGER.error(interruptedException);
    }
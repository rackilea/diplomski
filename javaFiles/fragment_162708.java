import java.util.concurrent.CountDownLatch;

int n = 10;
CountDownLatch doneSignal = new CountDownLatch(n);
// ... start threads ...
doneSignal.await();

// and within each thread:
doWork();
doneSignal.countDown();
private final CountDownLatch startLatch = new CountDownLatch(1);

public CountDownLatch getStartLatch() {
    return startLatch;
}

@Override
public void run() {
    // prepare to start, make sure all the runners are ready
    // ...

    // This will release all the waiting runners:
    startLatch.countDown();
}
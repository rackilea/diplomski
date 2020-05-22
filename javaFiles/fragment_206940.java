static CyclicBarrier b = new CyclicBarrier(nConnections);

public void run() {
    // make the database connection
    b.await();  //threads will stop here untill nConnections are opened
    ...
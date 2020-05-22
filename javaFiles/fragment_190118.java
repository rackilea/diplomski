while(true) {
    // call action to start N threads
    activeThreads = new AtomicInteger(N);
    action(N);
    // barrier to wait for threads to finish
    synchronized(locker) {
       while(activeThreads.get() > 0) {
           locker.wait();
       }
    }
}
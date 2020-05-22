try {
     // This line blocks execution till count down latch is 0
     // or after 30 seconds.
    cdl.await(30l, TimeUnit.SECONDS);
} catch (InterruptedException ie) {

}
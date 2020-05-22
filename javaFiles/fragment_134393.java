class Example {

    public static void main(String[] args) throws InterruptedException {
        final Semaphore s1 = new Semaphore(0);
        s1.acquire(); 
        // the thread is disabled
        // no permit is available
        // a blocking operation

        final Semaphore s2 = new Semaphore(1);
        s2.acquire();
        // returns immediately
        // one permit was available

        final Semaphore s3 = new Semaphore(0);
        if (s3.tryAcquire()) {
            // a non-blocking operation
            // returns false immediately
        }
    }

}
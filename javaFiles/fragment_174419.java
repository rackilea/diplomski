if ( threads.getAndIncrement() < 4 ) {
    final CountDownLatch innerLatch = new CountDownLatch( 1 );
    final Thread t = new Merger( innerLatch, b );
    t.start();
    mergeSort( a );
    while ( innerLatch.getCount() > 0 ) {
        try {
            innerLatch.await( 1000, TimeUnit.SECONDS );
        } catch ( InterruptedException e ) {
            // Up to you to decide what to do here
        }
    }
} else {
    mergeSort( a );
    mergeSort( b );
}
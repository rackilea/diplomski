executor.shutdown();

while ( !executor.isTerminated() ) {
    try {
        executor.awaitTermination( 5, TimeUnit.SECONDS);
    } catch ( InterruptedException e ) {
    }
}
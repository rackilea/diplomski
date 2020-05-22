// create a thread pool out in your program for background jobs
// then share that for all areas where you are doing background work, 
// network calls, etc.
ExecutorService executor = Executors.newFixedThreadPool(5);

public void doLongRunningThing() {
    final JProgressBar bar = ....; // this comes from somewhere, maybe you create it or look it up.

    executor.execute( new Runnable() {
        public void run() {
            ...same code as above...
        }
    } );        
}
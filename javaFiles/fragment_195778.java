public void run() throws InterruptedException {
    for( ;; ) {
        if( m.isChanged() ) //hopefully m is thread-safe
            m.toString();   //hopefully something more meaningful here
        Thread.sleep( 1000 ); //1000 milliseconds is one second.
    }
}
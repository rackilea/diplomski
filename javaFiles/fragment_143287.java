new Runnable() { 
    @Override public void run() {
        try {
            run0();
        } catch(Throwable t) { // this will catch everything not just Exceptions.
            // log t or print it
        }
    }
    void run0() {
        s_log.info("Resetting order books");
        _liveOrderBook.clear(); 
    } 
}
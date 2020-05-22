// stop the sample.  this invalidates the sample voice id.
nStop(id);

// wait for the callback
synchronized(lock) {
    if (id!=0) {
    try {
        //long time=System.currentTimeMillis();
        lock.wait(3000);
        //if (System.currentTimeMillis()-time > 2500) {
        //System.out.println(" WAITING TIMED OUT!"); System.out.flush();
        //id=0;
        //}
    } catch (InterruptedException e) { }
    }
}
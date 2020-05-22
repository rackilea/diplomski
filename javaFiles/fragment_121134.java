for (int i=0; i<5000;i++) {
    //Some business Process.
    if(Thread.currentThread().isInterrupted()) {
     // do any cleanup and return from here.
     return false;
    }
    j = i;
}
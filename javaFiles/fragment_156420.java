if(t!=null) {
    if(t.isAlive()) {
        t.interrupt();
        t.join();
    }
    t=null;
}
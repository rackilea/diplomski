// run outside the EDT
thread = new Thread(new Runnable() {
    @Override 
    public void run() { 
        Laccept();
    } 
}); 
thread.start();
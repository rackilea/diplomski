final Runnable myRunnable = new Runnable() {
    public boolean running = true;
    public void run() {
        while(running){
            doSomething();
        }
    }
};
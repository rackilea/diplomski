Runnable server = new Runnable() {
    public boolean running = true;
    public void run() {
        while(running){
            onServer();  // Make sure this blocks in some way
        }
    }
}
new Thread(server).start();
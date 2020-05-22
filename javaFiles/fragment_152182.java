Thread timerOutputThread = new Thread(new Runnable(){
    public boolean running = true;
    public void run(){
        output();
    }
    private void output(){
        try {
            Thread.sleep(1000);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("PRINT THE SCORE HERE");
        if(running){
            output();
        }
    }
});
timerOutputThread.start();
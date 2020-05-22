public static void delay(long delayMs, Runnable toRun){
    Thread t = new Thread(new Runnable(){
        public void run(){
            try { Thread.sleep(delayMs); }catch(InterruptedException ignored){}
            Platform.runLater(toRun);
        }
    });
    t.setDaemon(true);
    t.start();
}
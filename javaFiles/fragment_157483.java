Thread t = new Thread(new Runnable() { 
     public void run() {
         Music.stop();
     }
});
t.start();
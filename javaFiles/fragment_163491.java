mThread = new Thread(new Runnable() {
   @Override
   public void run() {

    // some code here 
    if (Thread.currentThread().isInterrupted()) return;
    // some here  
    if (Thread.currentThread().isInterrupted()) return;
    // some here
    if (Thread.currentThread().isInterrupted()) return;
    // some here          
    if (Thread.currentThread().isInterrupted()) return;
    // some here
    // all lines takes about 7-10 seconds    
   }
});
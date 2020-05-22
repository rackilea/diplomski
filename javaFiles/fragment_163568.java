class ThreadDemo extends Thread {
   private Object monitor; //This is the monitor
   private boolean keepRunning = true;
   private Thread t;

   ThreadDemo(){
       System.out.println("Creating thread");
   }

   public void callinOnResume(){
       synchronized(monitor){
           monitor.notify();
           }       
   }
   public void callinOnPause(){
           try {
                synchronized(monitor){
                    System.out.println(threadName +  "Waiting");
                    monitor.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted " + e.toString());
                }
    }

    public void run() {
       System.out.println("Starting to loop.");
        while (keepRunning) {
          //stuff
        }
        System.out.println("Done looping.");
    }

   public void start ()
   {
      System.out.println("Starting " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }
 }
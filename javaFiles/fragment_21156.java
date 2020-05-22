Thread t = new Thread(new Runnable(){

   public void run(){

           // Here is the code that will do your job every minute.

           // Please use a while loop with a loop control factor,

           // and sleep mechanism to let your thread sleep for a minute.

          // for sleep, instead of using Thread.sleep(timeout) better use     

          //TimeUnit.SECONDS.sleep(timeout);

     }
  });


t.start();
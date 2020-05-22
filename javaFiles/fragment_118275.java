Thread[] t = new Thread[6];
for(int i = 0; i < 6; i++) {
   t[i] = new Thread() {
     @Override
     public void run() {
        for(int i = 0; i < 60; i++) {
          //Pinging server.
          Thread.sleep(2000L);
          //Gets info from server here. That is why there is a 2 second delay.
        }
       }
     };
     t[i].start();
}

Thread.sleep(longEnough);
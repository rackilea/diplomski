public void someFunctino() {
    // set the timeout    
    // this will stop this function in 30 minutes
    long in30Minutes = 30 * 60 * 1000;
    Timer timer = new Timer();
    timer.schedule( new TimerTask(){
          public void run() {
               if( conditionsAreMet() ) { 
                   System.exit(0);
                }
           }
     },  in30Minutes );

     // do the work... 
      .... work for n time, it would be stoped in 30 minutes at most
      ... code code code
}
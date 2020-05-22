Timer timer=new Timer();

    // for each thread 't':
    t.suspend();
    final Thread tFinal=t;  
   // just a shortcut to allow my TimerTask to access 't' (alternatively you can 
   // have an explicit constructor for your TimerTask, and pass 't' to it)
    timer.schedule(
            new TimerTask() {
                @Override public void run() {
                    tFinal.resume();
                }
            }, 
            YOUR_RANDOM_VALUE);
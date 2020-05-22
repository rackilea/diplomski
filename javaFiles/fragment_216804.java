// CREATE A TIMER THREAD
       Timer timer = new Timer();
       timer.schedule(new TimerTask() {

           // this is what happens every time the timer runs
           @Override
           public void run() { 
             // check if your action should be preformed
             if (action.equals("A")) {
                 // ... do something
             }

           }

       }, 0, 1000);   // 1000 MILLESECONDS = 1 SECOND

       // note: you will need to run 'timer.cancel();' at some point to end your timer
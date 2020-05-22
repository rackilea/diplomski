timerRun=new Runnable()
        {
             @Override
             public void run() {

                 timerTVmainmenue.setText(competition.getTimerTime());
                 if (!competition.isTimerStarted){
                thandler.removeCallbacks(this);
                Log.d("MyLog","timerrun is blame for infinite butproc");
                 buttonsProcedure();
                 return;
             }
            thandler.postDelayed(this, 243); //looping this for every 243 ms
             }
        };
public void someMethod() 
   {
       //Start scheduledLogger() to work every 30 seconds
       TimerTask tasknew = new TimerTask(){
            @Override
            public void run()
            {
                scheduledLogger();

            }
        };
       Timer timer = new Timer();

       // scheduling the task
       timer.scheduleAtFixedRate(tasknew, new Date(), 3000);      

        //Do something taking long time
        try
        {
            Thread.sleep(20000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        //Stop scheduledLogger() job
        // terminating the timer
        timer.cancel();
    }

    private void scheduledLogger() {
        //Log to database
        System.out.println("Log to database at "+new Date());
    }
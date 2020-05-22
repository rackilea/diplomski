Timer t = new Timer();
long period = 5*60*1000; //For example 5 minutes
long delay = 1*60*1000; //For example 1 minute
t.schedule(new TimerTask() {
            @Override
            public void run() {
               //To do: Your code to be repeated each period ms
            }
        }, delay, period);
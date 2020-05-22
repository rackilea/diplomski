//Declare the timer
Timer t = new Timer();
//Set the schedule function and rate
t.scheduleAtFixedRate(new TimerTask() {

    @Override
    public void run() {
        //Called each time when 1000 milliseconds (1 second) (the period parameter)
    }

},
//Set how long before to start calling the TimerTask (in milliseconds)
0,
//Set the amount of time between each execution (in milliseconds)
1000);
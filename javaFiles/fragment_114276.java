Timer timer = new Timer(); //init the timer
Handler handler = new Handler();
int counter = 0; //counter to indicate the total second whenever timer fire

timerTask task = new timerTask();
timer.scheduleAtFixedRate(task,500,1000); //(which task to run,forget the usage try google, looping must be milisecond eg.1000 = 1 second)



private class timerTask extends TimerTask{
    @Override
    public void run() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                counter++;
                if(counter >= 100){ 
                    //do something
                }
            }
        });
    }
}
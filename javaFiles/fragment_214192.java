int SIX_HOURS = 1000 * 60 * 60 * 6;
Timer timer = new Timer(); 
timer.schedule( new TimerTask() 
{ 
    public void run() { 
    // do your work 
    } 
}, 0, SIX_HOURS);
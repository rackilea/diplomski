private long timerTime = Long.MIN_VALUE;

//on start timer
public void startTimer(View view){
    myChronometer.setBase(SystemClock.elapsedRealtime());
    myChronometer.start();
    timerTime = Long.MIN_VALUE;
}       

//on stop timmer
public void stopTimer(View view){
    myChronometer.stop();
    timerTime = SystemClock.elapsedRealtime() - myChronometer.getBase();
}

private long getTimerTime(){
    if(timerTime == Long.MIN_VALUE){
        return SystemClock.elapsedRealtime() - myChronometer.getBase();
    }

    return timerTime;
}
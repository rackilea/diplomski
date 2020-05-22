package com.uttara.reg;
import java.util.Date;
import java.util.TimerTask;
public class MyTimerTask extends TimerTask {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("inside run of timer");
    }
    public void scheduleAtFixedRate(TimerTask timerTask, Date executionDate, long period)
    {
        System.out.println("run");
        // TODO Auto-generated method stub

    }

}
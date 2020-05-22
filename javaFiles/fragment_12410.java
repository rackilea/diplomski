package com.example;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new App(), 0, 1000);
    }
}

class App extends TimerTask {

    int countdown = 100;

    public void run() {
        countdown = countdown - 1;
        System.out.println(countdown);
        //label.setText(countdown +"second's left");
    }

}

// Result:
//99
//98
//97
//96
//95
//94
package Package_main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Worker_Thread extends Thread {

volatile boolean stop;
double time_milli;

Robot robot;

public Worker_Thread (double t) {
    time_milli = t;
}

public void run() {

        try {
            this.robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(Worker_Thread.class.getName()).log(Level.SEVERE, null, ex);
        }
        stop = false;
        robot.delay(5000); //in milliseconds

        do {
            leftClick();
            robot.delay(1800);
            time_milli = time_milli - 2000;
            System.out.println(time_milli);

        } while (time_milli > 0 && (!stop));    

}

private void leftClick() {
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.delay(100);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);
    robot.delay(100);    

}

}
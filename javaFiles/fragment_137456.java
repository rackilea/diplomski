import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class MyTimer {
    ActionListener al = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            System.out.println("testing");
        }
    };

    public MyTimer() {
        Timer timer = new Timer(1000, al);
        timer.start();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new MyTimer();
            }
        });
    }
}
package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class BlinkColorTextField {

    BlinkColorTextField() {
        final JTextField blinkingText = new JTextField("Red & Blue");
        ActionListener blinker = new ActionListener() {
            boolean isRed = true;
            public void actionPerformed(ActionEvent ae) {
                if (isRed) {
                    blinkingText.setForeground(Color.BLUE);
                } else {
                    blinkingText.setForeground(Color.RED);
                }
                isRed = !isRed;
            }
        };
        Timer timer = new Timer(1000, blinker);
        timer.start();
        JOptionPane.showMessageDialog(null, blinkingText);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new BlinkColorTextField();
            }
        });
    }

}
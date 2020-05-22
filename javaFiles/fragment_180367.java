import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {

    public GUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Test Background");
        frame.setLocation(200, 100);
        frame.setSize(600, 400);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.getContentPane().setBackground(Color.BLUE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GUI gUI = new GUI();
            }
        });
    }
}
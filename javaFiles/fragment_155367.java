import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Example {

    public Example() {
        JFrame frame = new JFrame("Frame 1");
        JFrame frame2 = new JFrame("Frame 2");

        JLabel label = new JLabel("");

        JButton button = new JButton("Check");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(frame2.isDisplayable() ? "Active" : "Disposed");
            }
        });

        JPanel panel = new JPanel();
        panel.add(button);
        panel.add(label);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setVisible(true);

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.setSize(200, 100);
        frame2.setLocation(frame.getX() + frame.getWidth(), frame.getY());
        frame2.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Example();
            }
        });
    }
}
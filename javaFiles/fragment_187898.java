import java.awt.event.*;
import javax.swing.*;

public class JButtonTester {

    static int counter = 0;

    public static void main(String[] args) {

        final JLabel counter_label = new JLabel();
        class ClickCounter implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                counter++;
                System.out.println("Congratulations, you clicked a button " + counter + " time(s)! This might just be your greatest accomplishment");
                counter_label.setText("Count: " + counter);
            }
        }
        class ClickDecrement implements ActionListener {

            public void actionPerformed(ActionEvent event) {
                counter--;
                System.out.println("Congratulations, you clicked a button " + counter + " time(s)! This might just be your greatest accomplishment");
                counter_label.setText("Count: " + counter);
            }
        }
        JFrame firstFrame = new JFrame();
        JPanel firstPanel = new JPanel();
        firstPanel.add(counter_label);

        JButton firstButton = new JButton("Click me to increase your count!");
        firstPanel.add(firstButton);
        ActionListener firstListener = new ClickCounter();
        firstButton.addActionListener(firstListener);

        JButton secondButton = new JButton("Click me to decrease your count!");
        firstPanel.add(secondButton);
        ActionListener secondListener = new ClickDecrement();
        secondButton.addActionListener(secondListener);

        firstFrame.add(firstPanel);
        firstFrame.setSize(200, 120);
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstFrame.setVisible(true);
    }
}
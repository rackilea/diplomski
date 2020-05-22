import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

public class Foo {
    JLabel one;
    JLabel two;

    public static void main(String[] args) {
        (new Foo()).go();
    }

    public void go() {
        JFrame frame = new JFrame("Test");

        // Panel with buttons
        JPanel buttonPanel = new JPanel();
        JButton changeOne = new JButton("Change One");
        changeOne.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                one.setText("New text for one");
            }
        }
        buttonPanel.add(changeOne);
        JButton changeTwo = new JButton("Change Two");
        changeTwo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                two.setText("New text for two");
            }
        }
        buttonPanel.add(changeTwo);
        frame.add(buttonPanel, BorderLayout.NORTH);

        // Panel with labels
        JPanel labelPanel = new JLabel();
        one = new JLabel("One");
        labelPanel.add(one);
        two = new JLabel("Two");
        labelPanel.add(two);

        // Set up the frame
        frame.add(labelPanel, BorderLayout.SOUTH);
        frame.setBounds(50, 50, 500, 500);
        frame.setDefaultCloseAction(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
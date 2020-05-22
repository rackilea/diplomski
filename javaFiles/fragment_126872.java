import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class test extends JFrame {
    public static void main(String[] args) {
        new test();
    }

    public test() {
        super("Using JButton");
        Container content = getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());
        final JButton button = new JButton("First");
        final JButton button2 = new JButton("Second");
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked first button");
                button2.setVisible(!button2.isVisible());
            }
        });
        content.add(button);

        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.out.println("You clicked second button");
                button.setVisible(!button.isVisible());
            }
        });
        content.add(button2);
        pack();
        setVisible(true);
    }
}
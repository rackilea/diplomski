package sof;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CustomLayoutFrame{
    public static void main(String args[]) {
        JFrame frame = new JFrame("Custom Layout Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3,1));

        JButton but1 = new JButton("Button1");
        JButton but2 = new JButton("Button2");
        JButton but3 = new JButton("Button3");

        JButton[ ] myButtonArray = { but1, but2, but3 };
        ButtonHandler bh = new ButtonHandler();

        for (JButton cur : myButtonArray) {    // I tried standard for loop as well.
            cur.addActionListener(bh);
        }

        frame.add(but1);
        frame.add(but2);
        frame.add(but3);

        frame.setSize(300, 150);
        frame.setVisible(true);
      }
}

class ButtonHandler implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent arg0) {
        System.out.println(((JButton)(arg0.getSource())).getText() + " Clicked !");

    }
}
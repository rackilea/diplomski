package com.cat.frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BestCat implements ActionListener {
JFrame frame = new JFrame();
JFrame frame2 = new JFrame();
JFrame frame3 = new JFrame();
JFrame frame4 = new JFrame();
JFrame frame5 = new JFrame();
JButton button = new JButton();
JButton button2 = new JButton();
JButton button3 = new JButton();
JButton button4 = new JButton();
JTextArea area = new JTextArea();
JTextArea area2 = new JTextArea();
JTextArea area3 = new JTextArea();
JTextArea area4 = new JTextArea();
JTextArea area5 = new JTextArea();

void findBestCat() {

    frame.setSize(800, 600);
    frame.setVisible(true);
    frame.setLayout(null);
    frame.setBackground(Color.BLUE);
    frame.setTitle("Who's the Best cat?");

    area.setBounds(400, 0, 150, 75);
    area.setText("Who is the best cat?");

    // .setBounds(x, y, width, height);
    button.setBounds(50, 300, 150, 75);
    button.addActionListener(this);
    button.setText("Cheeto");

    button2.setBounds(250, 300, 175, 75);
    button2.addActionListener(this);
    button2.setText("Colby");

    button3.setBounds(450, 300, 175, 75);
    button3.addActionListener(this);
    button3.setText("Swirls");

    button4.setBounds(650, 300, 175, 75);
    button4.addActionListener(this);
    button4.setText("Monster");

    frame.add(button);
    frame.add(button2);
    frame.add(button3);
    frame.add(button4);
    frame.add(area);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    class actionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            button.getAction();
            button2.getAction();
            button3.getAction();
            button4.getAction();

            if (button.getAction() != null)
                frame2.setSize(600, 400);
            frame2.setVisible(true);
            frame2.setLayout(null);

            area2.setBounds(300, 200, 200, 200);
            area2.setText("Cheeto is an okay cat but he is a butt");

            frame2.add(area2);

            if (button2.getAction() != null)
                frame3.setSize(800, 600);
            frame3.setVisible(true);
            frame3.setLayout(null);

            area3.setBounds(300, 200, 200, 200);
            area3.setText("Cheeto is an okay cat but he is an");

            frame3.add(area3);

            if (button3.getAction() != null)
                frame4.setSize(800, 600);
            frame4.setVisible(true);
            frame4.setLayout(null);

            area4.setBounds(300, 200, 200, 200);
            area4.setText("Cheeto is an okay cat but he is a");

            frame4.add(area4);

            if (button4.getAction() != null)
                frame5.setSize(800, 600);
            frame5.setVisible(true);
            frame5.setLayout(null);

            area5.setBounds(300, 200, 200, 200);
            area5.setText("Cheeto is an okay cat but he i");

            frame5.add(area5);

        }
    }

}

@Override
public void actionPerformed(ActionEvent arg0) {
    // TODO Auto-generated method stub

}
}
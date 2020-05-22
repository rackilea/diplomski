package com.ggl.testing;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MainPage implements Runnable {

    @Override
    public void run() {
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.pink);
        panel1.setLayout(new FlowLayout());

        JButton button1 = new JButton("Programmer");
        panel1.add(button1);

        JFrame frame1 = new JFrame("Main Window");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel1);
        frame1.pack();

        frame1.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new MainPage());
    }
}
package sof;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame {

    public static void main(String[] args) {
        // Launch the frame:
        JFrame frame = new JFrame();
        frame.setTitle("Welcome!");
        frame.setSize(520, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add the image:
        ImageIcon heroShotImage = new ImageIcon("heroShot.jpg");
        JPanel heroShotPanel = new JPanel();
        JLabel heroShot = new JLabel(heroShotImage);
        heroShotPanel.add(heroShot);

        // Create a panel to hold the "Start" button:
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton start = new JButton("Start");
        start.setToolTipText("Click to use library");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I AM PRESSED");
            }
        });

        submitPanel.add(start);

        frame.getContentPane().add(heroShotPanel, BorderLayout.NORTH);
        frame.getContentPane().add(submitPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.getRootPane().setDefaultButton(start);
        start.requestFocus();
    }
}
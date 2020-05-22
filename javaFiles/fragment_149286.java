package com.apixandru.jvshot;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.BorderLayout.EAST;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author Alexandru-Constantin Bledea
 * @since Sep 12, 2016
 */
public class Test {

    public static void main(String[] args) {

        JButton jb = new JButton("Search");
        jb.addActionListener((evt) -> showMessageDialog(null, "Button 'clicked'"));

        JTextField jtf = new JTextField(15);
        jtf.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    jb.doClick();
                }
            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(jtf);
        panel.add(jb, EAST);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JFrame frame = new JFrame();
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

}
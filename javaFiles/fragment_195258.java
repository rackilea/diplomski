package javaapplication647;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DetectMotion extends JFrame {

    private JLabel label = null;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                DetectMotion frame = new DetectMotion();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public DetectMotion() {

        JPanel pnlButton = new JPanel();
        label = new JLabel("nothing");
        JButton btn = new JButton("Close");

        pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

        setTitle("Motion Detector");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("Close")) {
                    //TO-DO
                }
            }
        });

        JPanel panel = new JPanel() {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(200, 200);
            }

        };
        panel.setBackground(Color.RED);

        add(panel);
        pnlButton.add(label);
        pnlButton.add(btn);
        add(pnlButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

}
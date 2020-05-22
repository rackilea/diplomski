package helloworld;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Created on 4/30/17.
 */
public class SwapPanel {

    public static void main(String[] args){

        JPanel panel = new JPanel();
        panel.add(new JLabel("mover"));

        JFrame a = new JFrame("frame a");
        JButton aButton = new JButton("swap");
        JFrame b = new JFrame("frame b");
        JButton bButton = new JButton("swap");
        bButton.setEnabled(false);

        a.getContentPane().add(aButton, BorderLayout.SOUTH);
        a.getContentPane().add(panel, BorderLayout.CENTER);

        b.getContentPane().add(bButton, BorderLayout.SOUTH);

        aButton.addActionListener(evt->{
            if(aButton.isEnabled()){
                aButton.setEnabled(false);
                a.getContentPane().remove(panel);
                b.getContentPane().add(panel, BorderLayout.CENTER);
                bButton.setEnabled(true);
                a.pack();
                b.pack();
                a.repaint();
                b.repaint();
            }
        });

        bButton.addActionListener(evt->{
            if(bButton.isEnabled()){
                bButton.setEnabled(false);
                b.getContentPane().remove(panel);
                a.getContentPane().add(panel, BorderLayout.CENTER);
                aButton.setEnabled(true);
                a.pack();
                b.pack();
                a.repaint();
                b.repaint();
            }
        });


        a.pack();
        a.setVisible(true);
        b.pack();
        b.setVisible(true);

        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
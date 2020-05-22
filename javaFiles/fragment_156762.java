package org.swingsamples.label;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicArrowButton;

public class BasicArrowButtonTest {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frm = new JFrame("Test arrow button");
                JPanel p = new JPanel(new FlowLayout());
                BasicArrowButton btn = new BasicArrowButton(BasicArrowButton.WEST) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(100, 100);
                    }
                };
                p.add(btn);
                frm.add(p);
                frm.pack();
                frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }
}
package com.ggl.testing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GridBagLayoutTest implements Runnable {

    private static final Insets insets = new Insets(0, 0, 0, 0);

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new GridBagLayoutTest());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame(
                "Make a component span multiple rows in GridBagLayout when using only one column");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(createFlag());
        frame.pack();
        frame.setVisible(true);

    }

    private JPanel createFlag() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setPreferredSize(new Dimension(450, 300));

        JPanel row1 = new JPanel();
        row1.setBackground(new Color(237, 27, 36));

        JPanel row2 = new JPanel();
        row2.setBackground(Color.WHITE);

        JPanel row3 = new JPanel();
        row3.setBackground(new Color(26, 29, 80));

        JPanel row4 = new JPanel();
        row4.setBackground(Color.WHITE);

        JPanel row5 = new JPanel();
        row5.setBackground(new Color(237, 27, 36));

        // We are trying to draw Flag of Thailand
        int gridy = 0;
        addComponent(panel, row1, 0, gridy++, 1, 1, 1D, 1D,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(panel, row2, 0, gridy++, 1, 1, 1D, 1D,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(panel, row3, 0, gridy++, 1, 1, 1D, 2D,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(panel, row4, 0, gridy++, 1, 1, 1D, 1D,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addComponent(panel, row5, 0, gridy++, 1, 1, 1D, 1D,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH);

        return panel;
    }

    private void addComponent(Container container, Component component,
            int gridx, int gridy, int gridwidth, int gridheight,
            double weightx, double weighty, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, weightx, weighty, anchor, fill, insets,
                0, 0);
        container.add(component, gbc);
    }

}
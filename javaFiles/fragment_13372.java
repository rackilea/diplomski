package com.ggl.testing;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

public class ScrollPaneTest implements Runnable {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ScrollPaneTest());
    }

    @Override
    public void run() {
        JFrame frame = new JFrame("Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel cb = new JPanel();

        JScrollPane scrollPane = new JScrollPane(cb);
        scrollPane
                .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane
                .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(2000, 600));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                scrollPane, new JPanel());

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(150);

        Dimension minimumSize = new Dimension(600, 600);
        cb.setMinimumSize(minimumSize);

        frame.add(splitPane);

        frame.setSize(1200, 600);
        frame.setVisible(true);
    }

}
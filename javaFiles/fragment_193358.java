package com.thomaskuenneth;

import javax.swing.*;

public class Main {

    static boolean shouldCheck = true;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Demo");
            f.getContentPane().add(createUI());
            f.pack();
            f.setLocationRelativeTo(null);
            f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }

    static JComponent createUI() {
        String[][] rowData = new String[200][10];
        String[] columnNames = new String[10];
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    columnNames[j] = String.format("#%d", j);
                }
                rowData[i][j] = String.format("%d - %d", i, j);
            }
        }
        JTable t = new JTable(rowData, columnNames);
        JScrollPane sp = new JScrollPane(t);
        JScrollBar sb = sp.getVerticalScrollBar();
        JViewport vp = sp.getViewport();
        vp.addChangeListener((l) -> {
            if (!shouldCheck) {
                return;
            }
            if (sb.getValue() == sb.getMinimum()) {
                System.out.println("top");
            } else if (sb.getValue() + sb.getVisibleAmount() == sb.getMaximum()) {
                System.out.println("bottom");
            }
        });
        return sp;
    }
}
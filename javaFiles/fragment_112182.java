package com.zetcode;

import info.clearthought.layout.TableLayout;
import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TableLayoutGaps2 extends JFrame {

    public TableLayoutGaps2() {

        initUI();

        setTitle("Gaps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


   private void initUI() {

        JPanel base = new JPanel();
        base.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        );

        double cols[] = {
            TableLayout.PREFERRED,
            TableLayout.PREFERRED,
            TableLayout.PREFERRED
        };

        double rows[] = {
            TableLayout.PREFERRED,
            TableLayout.PREFERRED
        };

        TableLayout layout = new TableLayout(cols, rows);
        layout.setHGap(5);
        layout.setVGap(5);

        base.setLayout(layout);

        base.add(new JButton("Button"), "0, 0");
        base.add(new JButton("Button"), "1, 0");
        base.add(new JButton("Button"), "2, 0");
        base.add(new JButton("Button"), "0, 1");
        base.add(new JButton("Button"), "1, 1");
        base.add(new JButton("Button"), "2, 1");

        add(base);

        pack();
    }

    public static void main(String[] args) {

      EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TableLayoutGaps2 ex = new TableLayoutGaps2();
                ex.setVisible(true);
            }
        });
    }
}
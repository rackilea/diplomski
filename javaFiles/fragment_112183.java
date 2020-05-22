package com.zetcode;

import com.esotericsoftware.tablelayout.swing.Table;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;


public class TableLayoutGaps3 extends JFrame {

    public TableLayoutGaps3() {

        initUI();

        setTitle("Gaps");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


   private void initUI() {

        Table table = new Table();
        getContentPane().add(table);

        table.addCell(new JButton("Button")).pad(5, 5, 2.5f, 2.5f);
        table.addCell(new JButton("Button")).pad(5, 2.5f, 2.5f, 2.5f);
        table.addCell(new JButton("Button")).pad(5, 2.5f, 2.5f, 5);
        table.row();
        table.addCell(new JButton("Button")).pad(2.5f, 5, 5, 2.5f);
        table.addCell(new JButton("Button")).pad(2.5f, 2.5f, 5, 2.5f);
        table.addCell(new JButton("Button")).pad(2.5f, 2.5f, 5, 5);

        pack();
    }

    public static void main(String[] args) {

      EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TableLayoutGaps3 ex = new TableLayoutGaps3();
                ex.setVisible(true);
            }
        });
    }
}
package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class MigLayoutGrowEx extends JFrame {

    public MigLayoutGrowEx() {

        initUI();

        setSize(300, 250);
        setTitle("Grow constraint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout("wrap", "[grow]", "[][grow]"));

        JTextField field = new JTextField(10);
        JTextArea area = new JTextArea(10, 10);

        pnl.add(field, "growx");
        pnl.add(new JScrollPane(area), "grow");

        add(pnl);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutGrowEx ex = new MigLayoutGrowEx();
                ex.setVisible(true);
            }
        });
    }
}
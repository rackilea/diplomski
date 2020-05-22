package com.zetcode;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;


public class MigLayoutPushEx extends JFrame {

    public MigLayoutPushEx() {

        initUI();

        setSize(300, 250);
        setTitle("Push constraint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout("wrap"));

        JTextField field = new JTextField(10);
        JTextArea area = new JTextArea(10, 10);        

        pnl.add(field, "pushx, growx");
        pnl.add(new JScrollPane(area), "push, grow");

        add(pnl);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutPushEx ex = new MigLayoutPushEx();
                ex.setVisible(true);
            }
        });
    }
}
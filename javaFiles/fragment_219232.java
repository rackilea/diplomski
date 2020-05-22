package com.zetcode;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;


public class MigLayoutFillEx extends JFrame {

    public MigLayoutFillEx() {

        initUI();

        setSize(300, 250);
        setTitle("Fill");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initUI() {

        JPanel pnl = new JPanel(new MigLayout("fill"));

        pnl.add(getLabel("Area 1"), "cell 0 0, growx");
        pnl.add(getLabel("Area 2"), "cell 0 1, grow");
        pnl.add(getLabel("Area 3"), "cell 1 0 1 2, grow");

        add(pnl);
    }

    private JLabel getLabel(String text) {

        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setBorder(BorderFactory.createEtchedBorder());

        return label;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MigLayoutFillEx ex = new MigLayoutFillEx();
                ex.setVisible(true);
            }
        });
    }
}
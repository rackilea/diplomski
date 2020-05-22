package com.kcing.kailas.sample.client;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

public class Testing extends JFrame {

    private JPanel jContentPane = null;

    public Testing() {
        super();
        initialize();
    }

    private void initialize() {
        this.setSize(300, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("JFrame");
    }

    private JPanel getJContentPane() {
        if (jContentPane == null) {
            jContentPane = new JPanel();
            jContentPane.setLayout(null);

            JPanel panel = new JPanel();

            panel.setBounds(61, 11, 81, 140);
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            jContentPane.add(panel);

            JCheckBox c1 = new JCheckBox("Check1");
            panel.add(c1);
            c1 = new JCheckBox("Check2");
            panel.add(c1);
            c1 = new JCheckBox("Check3");
            panel.add(c1);
            c1 = new JCheckBox("Check4");
            panel.add(c1);
        }
        return jContentPane;
    }

    public static void main(String[] args) throws Exception {
        Testing frame = new Testing();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
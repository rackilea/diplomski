import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JFrame {

    public static void main(String[] args) {
        final JFrame f = new JFrame();
        JPanel p0 = new JPanel(new GridBagLayout());

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        p1.setBorder(BorderFactory.createTitledBorder("panel 1"));
        p2.setBorder(BorderFactory.createTitledBorder("panel 2"));
        p3.setBorder(BorderFactory.createTitledBorder("panel 3"));
        p4.setBorder(BorderFactory.createTitledBorder("panel 4"));
        p1.setBackground(Color.RED);
        p2.setBackground(Color.GREEN);
        p3.setBackground(Color.BLUE);
        p4.setBackground(Color.CYAN);

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.ipadx = 50;
        p0.add(p1, c);

        c.gridy = 1;
        c.fill = GridBagConstraints.VERTICAL;
        c.weighty = 1;
        p0.add(p2, c);

        c.gridx = 1;
        c.gridy = 0;
        c.ipadx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 0;
        c.weightx = 1;
        p0.add(p3, c);

        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1;
        c.gridy = 1;
        p0.add(p4, c);

        f.getContentPane().add(p0,BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }

}
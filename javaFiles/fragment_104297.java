import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestClass extends JFrame {

    public TestClass() {
        super("test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        final JPanel upper = new JPanel();
        GridBagLayout gridbag = new GridBagLayout();
        upper.setLayout(gridbag);
        GridBagConstraints gbc = new GridBagConstraints();

        final JButton toolbar1 = new JButton("toolbar1");
        final JButton toolbar2 = new JButton("toolbar2");
        final JButton toolbar3 = new JButton("toolbar3");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.WEST;
        upper.add(toolbar1, gbc);


        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        upper.add(toolbar2, gbc);


        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        upper.add(toolbar3, gbc);


        add(upper, BorderLayout.NORTH);

        final JPanel something = new JPanel();
        something.setBackground(Color.WHITE);
        something.setPreferredSize(new Dimension(600, 600));
        something.repaint();
        add(something, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        final TestClass test = new TestClass();
    }
}
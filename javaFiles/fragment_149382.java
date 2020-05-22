import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestFrame extends JFrame {

    public TestFrame() {
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setLayout(new GridBagLayout());
        for (int i = 0; i < 5; i++) {
            JLabel expLabel = new JLabel(""+i);
            String sExpName = "text"+i;

            add(expLabel, getConstraint(new int[] {1, i, 1, 1}));
            JTextField expTextField = new JTextField();
            expTextField.setText(sExpName);
            add(expTextField, getConstraint(new int[] {2, i, 1, 1}));
        }
        GridBagConstraints c = getConstraint(new int[] {1,6,2,1});
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;
        add(new JLabel(" "),c);
    }

    private GridBagConstraints getConstraint(int[] c) {
        GridBagConstraints g = new GridBagConstraints();
        g.gridx = c[0];
        g.gridy = c[1];
        g.gridwidth = c[2];
        g.gridheight = c[3];
        g.anchor = GridBagConstraints.FIRST_LINE_START;
        g.ipadx = 30;
        g.ipady = 15;
        return g;
    }


    public static void main(String args[]) {
        new TestFrame();
    }

}
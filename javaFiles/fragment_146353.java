import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TestFrame extends JFrame {

    JLabel l1;
    JCheckBox matchCase, MatchWholeWords;
    JTextField tf;
    JButton find_next, cancel;

    public TestFrame() {
        l1 = new JLabel("Find What: ");
        matchCase = new JCheckBox();
        matchCase.setText("Match Case ");
        MatchWholeWords = new JCheckBox("Match Whole Words ");
        tf = new JTextField(30);
        find_next = new JButton("Find Next");
        cancel = new JButton("Cancel");

        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        add(l1, c);
        c.gridx++;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;
        add(tf, c);
        c.fill = GridBagConstraints.NONE;
        c.weightx = 0;
        c.gridx++;
        add(find_next, c);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(matchCase, c);
        c.gridx++;
        c.gridx++;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(cancel, c);
        c.gridy++;
        c.gridx = 0;
        c.gridwidth = 2;
        add(MatchWholeWords, c);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame();
    }
}
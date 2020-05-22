import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TestLayout20 {

    public static void main(String[] args) {
        new TestLayout20();
    }

    public TestLayout20() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            JLabel lblname = new JLabel("Name");
            gbc.gridx = 0;
            gbc.gridy = 0;

            add(lblname, gbc);

            JTextField textname = new JTextField(11);
            gbc.gridx = 1;
            gbc.gridy = 0;

            add(textname, gbc);

            JLabel lblEmail = new JLabel("Email ");
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(lblEmail, gbc);

            JTextField TextEmail = new JTextField(11);
            gbc.gridx = 1;
            gbc.gridy = 1;
            add(TextEmail, gbc);

            JLabel lblgender = new JLabel("Gender");
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(lblgender, gbc);

            JTextField TextGender = new JTextField(11);
            gbc.gridx = 1;
            gbc.gridy = 2;
            add(TextGender, gbc);

            JButton New = new JButton("New");
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.insets = new Insets(0, 12, 0, 0);
            gbc.gridx = 2;
            gbc.gridy = 0;
            add(New, gbc);

            JButton edit = new JButton("Edit");
            gbc.gridx = 2;
            gbc.gridy = 1;

            add(edit, gbc);

            JButton Gender = new JButton("Gender");
            gbc.gridx = 2;
            gbc.gridy = 2;

            add(Gender, gbc);

            JPanel pnlNav = new JPanel(new GridBagLayout());
            gbc.insets = new Insets(12, 0, 0, 0);
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(pnlNav, gbc);

            JTextField count = new JTextField(5);
            gbc = new GridBagConstraints();
            gbc.gridx = 1;
            gbc.gridy = 0;
            pnlNav.add(count, gbc);

            JButton pre = new JButton("<<");
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
            gbc.gridx = 0;
            gbc.gridy = 0;
            pnlNav.add(pre, gbc);

            JButton next = new JButton(">>");
            gbc.anchor = GridBagConstraints.EAST;
            gbc.gridx = 2;
            gbc.gridy = 0;
            pnlNav.add(next, gbc);

        }
    }
}
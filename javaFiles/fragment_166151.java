import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FormLayout {

    public static void main(String[] args) {
        new FormLayout();
    }

    public FormLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
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
            JLabel FNLabel = new JLabel("First Name: ");
            JLabel MILabel = new JLabel("Middle Initial: ");
            JLabel LNLabel = new JLabel("Last Name: ");
            JLabel IDLabel = new JLabel("Student ID: ");
            JLabel EmailLabel = new JLabel("E-mail Address: ");

            JLabel FNInfo = new JLabel("My first name");
            JLabel MIInfo = new JLabel("My initial");
            JLabel LNInfo = new JLabel("My last name");
            JLabel IDInfo = new JLabel("My student id");
            JLabel EmailInfo = new JLabel("My Email");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(2, 2, 2, 2);
            gbc.anchor = GridBagConstraints.WEST;

            add(FNLabel, gbc);
            gbc.gridy++;
            add(MILabel, gbc);
            gbc.gridy++;
            add(LNLabel, gbc);
            gbc.gridy++;
            add(IDLabel, gbc);
            gbc.gridy++;
            add(EmailLabel, gbc);

            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;

            add(FNInfo, gbc);
            gbc.gridy++;
            add(MIInfo, gbc);
            gbc.gridy++;
            add(LNInfo, gbc);
            gbc.gridy++;
            add(IDInfo, gbc);
            gbc.gridy++;
            add(EmailInfo, gbc);                
        }
    }
}
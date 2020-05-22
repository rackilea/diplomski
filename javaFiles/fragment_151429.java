import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LayoutExample {

    public static void main(String[] args) {
        new LayoutExample();
    }

    public LayoutExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            JLabel longText = new JLabel("Long Text Example");
            JLabel shortText = new JLabel("Short Example");
            JLabel medText = new JLabel("Medium Example");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.EAST;
            add(longText, gbc);
            addFields(gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.EAST;
            add(shortText, gbc);
            addFields(gbc);

            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.EAST;
            add(medText, gbc);
            addFields(gbc);
        }

        protected void addFields(GridBagConstraints gbc) {
            JTextField field1 = new JTextField("0", 5);
            field1.setEnabled(false);
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridx++;
            add(field1, gbc);
            gbc.gridx++;
            gbc.insets = new Insets(0, 4, 0, 4);
            add(new JLabel("+"), gbc);
            JTextField field2 = new JTextField(5);
            gbc.gridx++;
            add(field2, gbc);
        }

    }

}
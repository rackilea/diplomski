import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Test");
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() throws HeadlessException {
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2);
            JPanel fieldPane = new JPanel(new GridBagLayout());

            JTextField inputField = new JTextField("Computer Science 1");
            fieldPane.add(new JLabel("Input Text:"), gbc);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            fieldPane.add(inputField, gbc);

            JPanel buttonPane = new JPanel(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2);

            buttonPane.add(new JButton("Computer Statistics"), gbc);
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.weightx = 1;
            buttonPane.add(new JButton("Clear Text"), gbc);

            JPanel resultsPane = new JPanel(new GridBagLayout());
            gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2);

            resultsPane.add(new JLabel("Text Statistics Result:"));
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.weightx = 1;
            resultsPane.add(new JLabel("3 words"), gbc);

            gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(fieldPane, gbc);
            add(buttonPane, gbc);
            add(resultsPane, gbc);
        }

    }

}
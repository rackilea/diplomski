import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestUnicodeFont {

    public static void main(String[] args) {
        new TestUnicodeFont();
    }

    public TestUnicodeFont() {
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
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JLabel normal = new JLabel("Normal - ?");
            JLabel byCode = new JLabel("Normal code - \u2109");

            JLabel normalLarger = new JLabel("Large - ?");
            normalLarger.setFont(normalLarger.getFont().deriveFont(48f));
            JLabel byCodeLatger = new JLabel("Large code - \u2109");
            byCodeLatger.setFont(byCodeLatger.getFont().deriveFont(48f));

            add(normal, gbc);
            add(byCode, gbc);
            add(normalLarger, gbc);
            add(byCodeLatger, gbc);
        }
    }

}
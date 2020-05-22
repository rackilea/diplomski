import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout {

    public static void main(String[] args) {
        new TestLayout();
    }

    public TestLayout() {
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
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(8, 8, 2, 8);
            add(new JLabel(new ImageIcon(getClass().getResource("/gender_neutral_user.png"))), gbc);
            gbc.gridx++;
            gbc.insets = new Insets(8, 2, 4, 8);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(new JTextField(10), gbc);

            JList list = new JList();
            list.setVisibleRowCount(10);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.insets = new Insets(4, 8, 8, 8);
            gbc.fill = GridBagConstraints.BOTH;
            add(new JScrollPane(list), gbc);
        }

    }

}
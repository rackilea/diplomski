import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FlipDialog {

    public static void main(String[] args) {
        new FlipDialog();
    }

    public FlipDialog() {
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

        private JButton flip;
        private JPanel bottom;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(8, 8, 8, 8);
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            JPanel top = new JPanel();
            flip = new JButton("+");
            top.add(flip);
            add(top, gbc);

            bottom = new JPanel();
            bottom.add(new JLabel("Boo"));
            bottom.setVisible(false);

            add(bottom, gbc);

            flip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    bottom.setVisible(!bottom.isVisible());
                    if (bottom.isVisible()) {
                        flip.setText("-");
                    } else {
                        flip.setText("+");
                    }
                    revalidate();
                    Window window = SwingUtilities.windowForComponent(bottom);
                    window.pack();
                }
            });
        }

    }

}
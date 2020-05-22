import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SpiningLabel {

    public static void main(String[] args) {
        new SpiningLabel();
    }

    public SpiningLabel() {
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

        private ImageIcon spin;
        private ImageIcon still;

        private JLabel label;
        private Timer timer;
        private JButton button;

        public TestPane() {
            spin = new ImageIcon("spin.gif");
            still = new ImageIcon("still.png");

            label = new JLabel(still);
            button = new JButton("Allons-y!");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setIcon(spin);
                    button.setEnabled(false);
                    timer.restart();
                }
            });
            timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setIcon(still);
                    button.setEnabled(true);
                }
            });
            timer.setRepeats(false);

            setLayout(new BorderLayout());
            add(label);
            add(button, BorderLayout.SOUTH);
        }
    }

}
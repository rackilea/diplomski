import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TimeExample {

    public static void main(String[] args) {
        new TimeExample();
    }

    public TimeExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridBagLayout());
                frame.add(new TestPane());
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Timer timer;

        public TestPane() {
            setBorder(new LineBorder(Color.BLACK));

            timer = new Timer(6000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setBackground(Color.RED);
                }
            });
            timer.setRepeats(false);

            MouseAdapter ma = new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (timer.isRunning()) {
                        timer.stop();
                        setBackground(Color.BLUE);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!timer.isRunning()) {
                        timer.restart();
                        setBackground(UIManager.getColor("Panel.background"));
                    }
                }

                /**
                 * Testing purposes only!!
                 *
                 * @param e
                 */
                @Override
                public void mouseClicked(MouseEvent e) {
                    setBackground(UIManager.getColor("Panel.background"));
                    timer.restart();
                }

            };
            addMouseListener(ma);

            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

    }

}
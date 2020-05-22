import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TimerExample {

    public static void main(String[] args) {
        new TimerExample();
    }

    public TimerExample() {
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

    public static class TestPane extends JPanel {

        private JLabel label;
        private JButton button;

        private Timer hisTimer;
        private Timer herTimer;

        public static final int DELAY = 1000;

        public TestPane() {
            setLayout(new BorderLayout());
            label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            button = new JButton("Start");

            hisTimer = new Timer(DELAY, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("His");
                }
            });
            hisTimer.setInitialDelay(DELAY / 2);
            hisTimer.setCoalesce(true);

            herTimer = new Timer(DELAY, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    label.setText("Hers");
                }
            });
            herTimer.setCoalesce(true);

            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (hisTimer.isRunning() && herTimer.isRunning()) {
                        hisTimer.stop();
                        herTimer.stop();
                        button.setText("Start");
                    } else {
                        hisTimer.start();
                        herTimer.start();
                        button.setText("Stop");
                    }
                }
            });

            add(button, BorderLayout.SOUTH);
            add(label);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}
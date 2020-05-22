import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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

    public static class TestPane extends JPanel {

        private JLabel label;
        private JButton button;

        private Timer timer;
        private long startedAt;

        public static final int RUN_TIME = 5000;

        public TestPane() {
            label = new JLabel("...");
            button = new JButton("Start");
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            add(label, gbc);
            add(button, gbc);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timer == null) {
                        button.setText("Stop");
                        startedAt = System.currentTimeMillis();
                        timer = new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                long diff = System.currentTimeMillis() - startedAt;
                                if (diff >= RUN_TIME) {
                                    label.setText("Out of time; Used: " + remainingTime() + "s; remaining " + usedTime() + "s");
                                    timer.stop();
                                    button.setText("Start");
                                } else {
                                    label.setText("Used: " + remainingTime() + "s; remaining " + usedTime() + "s");
                                }
                            }
                        });
                        label.setText("Used: " + remainingTime() + "s; remaining " + usedTime() + "s");
                        timer.start();
                    } else {
                        timer.stop();
                        long diff = System.currentTimeMillis() - startedAt;
                        label.setText("Used: " + remainingTime() + "s; remaining " + usedTime() + "s");
                        button.setText("Start");
                        timer = null;
                    }
                }
            });
        }

        public int remainingTime() {
            long diff = System.currentTimeMillis() - startedAt;
            return (int) Math.round((RUN_TIME - diff) / 1000d);
        }

        public int usedTime() {
            long diff = System.currentTimeMillis() - startedAt;
            return (int) Math.round(diff / 1000d);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

    }

}
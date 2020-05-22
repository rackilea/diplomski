import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    public class TestPane extends JPanel {

        private JProgressBar pb;
        private JButton button;

        private Worker worker;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            pb = new JProgressBar();
            button = new JButton("Run");

            add(pb, gbc);
            add(button, gbc);

            pb.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    System.out.println(pb.getValue());
                    if (pb.getValue() >= 100) {
                        button.setText("Run");
                        worker = null;
                    }
                }
            });

            pb.addPropertyChangeListener("value", new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                }
            });

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (worker == null) {
                        worker = new Worker(pb);
                        Thread t = new Thread(worker);
                        t.start();
                        button.setText("Pause");
                    } else {
                        if (worker.isPaused()) {
                            button.setText("Pause");
                            worker.resume();
                        } else {
                            button.setText("Resume");
                            worker.pause();
                        }
                    }
                }
            });
        }

    }

    public class Worker implements Runnable {

        private ReentrantLock pausedLock;
        private Condition pausedCondition;
        private AtomicBoolean paused;

        private JProgressBar pb;

        public Worker(JProgressBar pb) {
            paused = new AtomicBoolean(false);
            pausedLock = new ReentrantLock();
            pausedCondition = pausedLock.newCondition();
            this.pb = pb;
        }

        public void pause() {

            paused.set(true);

        }

        public void resume() {

            paused.set(false);
            pausedLock.lock();
            try {
                pausedCondition.signal();
            } finally {
                pausedLock.unlock();
            }

        }

        @Override
        public void run() {

            int times = 100_000;
            for (int i = 0; i <= times; i++) {
                checkPauseState();
                updateProgress(Math.round((i / (float) times) * 100f));
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
            }

        }

        protected void checkPauseState() {

            while (paused.get()) {
                pausedLock.lock();
                try {
                    pausedCondition.await();
                } catch (InterruptedException ex) {
                } finally {
                    pausedLock.unlock();
                }
            }

        }

        protected void updateProgress(int progress) {
            if (EventQueue.isDispatchThread()) {
                pb.setValue(progress);
            } else {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        updateProgress(progress);
                    }
                });
            }
        }

        public  boolean isPaused() {
            return paused.get();
        }

    }

}
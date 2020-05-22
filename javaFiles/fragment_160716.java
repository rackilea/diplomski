import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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

    public class TestPane extends JPanel implements Value {

        private JLabel label;
        private volatile int value = 0;

        private ManipulateRunner incrementRunner;
        private ManipulateRunner decrementRunner;

        private Thread incrementThread;
        private Thread decrementThread;

        public TestPane() {

            incrementRunner = new ManipulateRunner(this, 1);
            decrementRunner = new ManipulateRunner(this, -1);

            setLayout(new GridBagLayout());
            label = new JLabel("0");
            add(label);
            addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {

                    decrementRunner.pause();
                    if (incrementThread == null) {
                        incrementThread = new Thread(incrementRunner);
                        incrementThread.start();
                    }

                    incrementRunner.resume();

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                    incrementRunner.pause();
                    if (decrementThread == null) {
                        decrementThread = new Thread(decrementRunner);
                        decrementThread.start();
                    }

                    decrementRunner.resume();

                }

            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public void setValue(final int value) {
            if (EventQueue.isDispatchThread()) {
                this.value = value;
                label.setText(Integer.toString(value));
            } else {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        setValue(value);
                    }
                });
            }
        }

    }

    public static interface Value {

        public int getValue();

        public void setValue(int value);
    }

    public static class ManipulateRunner implements Runnable {

        protected final Object pauseLock = new Object();
        private int delta;
        private AtomicBoolean paused = new AtomicBoolean(false);
        private AtomicBoolean stopped = new AtomicBoolean(false);
        private Value value;

        public ManipulateRunner(Value value, int delta) {
            this.delta = delta;
            this.value = value;
        }

        public void pause() {

            if (!paused.get() && !stopped.get()) {

                paused.set(true);
                synchronized (pauseLock) {
                    pauseLock.notify();
                }

            }

        }

        public void resume() {

            if (paused.get() && !stopped.get()) {

                paused.set(false);
                synchronized (pauseLock) {
                    pauseLock.notify();
                }

            }

        }

        public void stop() {

            if (!stopped.get()) {

                stopped.set(true);
                synchronized (pauseLock) {
                    pauseLock.notify();
                }

            }

        }

        @Override
        public void run() {

            while (!stopped.get()) {

                while (!stopped.get() && paused.get()) {
                    synchronized (pauseLock) {
                        try {
                            pauseLock.wait();
                        } catch (InterruptedException ex) {
                        }
                    }
                }

                if (!stopped.get()) {
                    value.setValue(value.getValue() + delta);

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                    }
                }

            }

        }

    }

}
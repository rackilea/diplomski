import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

public class FadeMenu {

    private AnimationEngine engine;

    public static void main(String[] args) {
        new FadeMenu();
    }

    public FadeMenu() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                engine = new AnimationEngine();

                JMenuBar mb = new JMenuBar();
                JMenu flip = new JMenu("Flip");

                flip.add("Static 1");
                flip.add("Static 2");
                flip.add("Static 3");

                flip.add(new FadeMenuItem("Fade 1"));
                flip.add(new FadeMenuItem("Fade 2"));
                flip.add(new FadeMenuItem("Fade 3"));
                flip.add(new FadeMenuItem("Fade 4"));

                mb.add(flip);

                JFrame frame = new JFrame("Testing");
                frame.setJMenuBar(mb);
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
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }

    public class FadeMenuItem extends JMenuItem {

        public FadeMenuItem(String text) {
            super(text);
            engine.addTimingListener(new TimingListener() {
                @Override
                public void timingEvent() {
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(engine.getAlpha()));
            super.paintComponent(g2d);
            g2d.dispose();
        }

        @Override
        public void removeNotify() {
            Container parent = getParent();
            if (parent instanceof JPopupMenu) {
                JPopupMenu menu = (JPopupMenu) parent;
                engine.stop();
            }
            super.removeNotify(); 
        }

        @Override
        public void addNotify() {
            super.addNotify();
            Container parent = getParent();
            if (parent instanceof JPopupMenu) {
                JPopupMenu menu = (JPopupMenu) parent;
                engine.restart();
            }
        }
    }

    public interface TimingListener {

        public void timingEvent();
    }

    public class AnimationEngine {

        private Timer fade;
        private float alpha;
        private long startTime;
        private long duration = 1000;
        private List<TimingListener> listeners;

        public AnimationEngine() {
            listeners = new ArrayList<>(5);
            fade = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    long elapsed = System.currentTimeMillis() - startTime;
                    if (elapsed >= duration) {
                        ((Timer) e.getSource()).stop();
                        alpha = 1f;
                    } else {
                        alpha = (float) elapsed / (float) duration;
                    }
                    fireTimingEvent();
                }
            });
            fade.setRepeats(true);
            fade.setCoalesce(true);
            fade.setInitialDelay(500);
        }

        public void addTimingListener(TimingListener listener) {
            listeners.add(listener);
        }

        public void removeTimingListener(TimingListener listener) {
            listeners.add(listener);
        }

        protected void fireTimingEvent() {
            for (TimingListener listener : listeners) {
                listener.timingEvent();
            }
        }

        public void restart() {
            fade.stop();
            alpha = 0;
            fireTimingEvent();
            startTime = System.currentTimeMillis();
            fade.start();
        }

        public float getAlpha() {
            return alpha;
        }

        public void stop() {
            fade.stop();
        }
    }
}
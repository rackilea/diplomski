import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.basic.BasicProgressBarUI;

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

        private JProgressBar bar;

        public TestPane() {
            bar = new JProgressBar();
            bar.setIndeterminate(true);
            bar.setOpaque(true);
            bar.setUI(new BarUI());
            bar.setPreferredSize(new Dimension(180, 10));
            bar.setBackground(new Color(184, 184, 184, 255));
            bar.setForeground(new Color(0, 126, 255, 255));
            add(bar);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class BarUI extends BasicProgressBarUI {

        private Rectangle r = new Rectangle();

        @Override
        protected void paintIndeterminate(Graphics g, JComponent c) {
            Graphics2D G2D = (Graphics2D) g;
            G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                                     RenderingHints.VALUE_ANTIALIAS_ON);
            r = getBox(r);
            g.setColor(c.getForeground());
            g.fillRect(r.x,r.y,r.width,r.height);
        }
    }

}
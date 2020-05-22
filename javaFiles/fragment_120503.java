import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFrame;
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

    public class TestPane extends JPanel {

        private TimeLine timeLine;
        private float alpha = 0;

        public TestPane() {
            timeLine = new TimeLine(Duration.ofSeconds(5));
            timeLine.add(0.0f, 1.0f);
            timeLine.add(0.5f, 0.0f);
            timeLine.add(1.0f, 1.0f);
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!timeLine.isRunning()) {
                        timeLine.start();
                    }
                    alpha = timeLine.getValue();
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.SrcOver.derive(alpha));
            g2d.setColor(Color.RED);
            g2d.fill(new Rectangle(45, 45, 110, 110));
            g2d.dispose();

            g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.fill(new Rectangle(50, 50, 100, 100));
            g2d.setColor(Color.BLACK);
            g2d.draw(new Rectangle(50, 50, 100, 100));
            g2d.dispose();
        }

    }
}
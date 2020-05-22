import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.java.balloontip.CustomBalloonTip;
import net.java.balloontip.examples.complete.Utils;

public class TestBalloon {

    public static void main(String[] args) {
        new TestBalloon();
    }

    public TestBalloon() {
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

        private CustomBalloonTip customBalloonTip;

        private List<Line2D> lines = new ArrayList<>(25);
        private Point2D hitPoint = null;

        public TestPane() {

            customBalloonTip = new CustomBalloonTip(this,
                    new JLabel("<html>I'm a " + Utils.monospace("CustomBalloonTip") + ".</html>"),
                    new Rectangle(0, 0, 1, 1),
                    Utils.createBalloonTipStyle(),
                    Utils.createBalloonTipPositioner(),
                    null);
            customBalloonTip.setVisible(false);

            lines.add(new Line2D.Float(0, 0, 300, 300));
            lines.add(new Line2D.Float(300, 0, 0, 300));

            hitPoint = null;

            addMouseMotionListener(new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {

                    Point mp = e.getPoint();
                    Rectangle offset = null;

                    for (Line2D line : lines) {
                        double distance = line.ptSegDist(mp);
                        if (distance <= 4) {
                            offset = new Rectangle(mp, new Dimension(1, 1));
                        }
                    }

                    if (offset != null) {
                        System.out.println(offset);
                        customBalloonTip.setOffset(offset);
                        customBalloonTip.setVisible(true);
                    } else {
                        customBalloonTip.setVisible(false);
                    }

                    repaint();
                }

            });

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            for (Line2D line : lines) {
                g2d.draw(line);
            }

            if (hitPoint != null) {
                Ellipse2D ellipse = new Ellipse2D.Double(hitPoint.getX() - 5, hitPoint.getY() + 5, 10, 10);
                g2d.fill(ellipse);
            }
            g2d.dispose();
        }
    }
}
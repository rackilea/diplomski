import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class TrailTest {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        TrailPanel p = new TrailPanel();
        p.setOpaque(false);
        p.addMouseMotionListener(new MouseInputAdapter() {

            // must remember to connect the current with the last one
            private Point lastPoint = null;

            @Override
            public void mouseMoved(MouseEvent e) {
                final Point mouseLocation = e.getPoint();
                if (lastPoint != null) {
                    p.put(mouseLocation);
                    p.connect(mouseLocation, lastPoint);
                }
                lastPoint = mouseLocation;
                p.repaint();
            }
        });
        f.add(p);
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    private static class TrailPanel extends JPanel {

        private static final long serialVersionUID = 214019134136464119L;

        private ConcurrentHashMap<Point, Integer> points;
        private LinkedHashMap<Point, Point> lines;

        public TrailPanel() {
            points = new ConcurrentHashMap<>();
            lines = new LinkedHashMap<>();
            Thread t = new Thread(() -> {
                while (true) {
                    points.replaceAll((k, v) -> v - 10);
                    points.entrySet().removeIf(entry -> entry.getValue() < 0);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    repaint();
                }
            });
            t.start();
        }

        public void connect(Point p1, Point p2) {
            lines.put(p1, p2);
        }

        public void put(Point p) {
            points.put(p, 1020);
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke(3));

            for (Entry<Point, Integer> entry : points.entrySet()) {
                Point p = entry.getKey();
                try {
                    g2d.setColor(new Color(255, 0, 0, entry.getValue() / 4));
                } catch (IllegalArgumentException ex) {}
                //might want to comment drawArc if you want to make it look better by a liiiiitle.
                g2d.drawArc((int) p.getX(), (int) p.getY(), 1, 1, 0, 360);
                g2d.drawLine((int) p.getX(), (int) p.getY(), (int) lines.get(p).getX(), (int) lines.get(p).getY());
            }
        }
    }
}
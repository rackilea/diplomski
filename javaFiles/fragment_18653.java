import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

        private boolean dragging = false;

        private Point anchor;
        private Point target;

        private Shape fakePath;

        private List<Shape> shapes = new ArrayList<>(25);

        public TestPane() {
            addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    dragging = true;
                    target = new Point(e.getPoint());
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    if (target != null && anchor != null) {
                        fakePath = makePath(anchor, e.getPoint(), target);
                        repaint();
                    }
                }

            });

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    if (anchor == null) {
                        target = null;
                        anchor = new Point(e.getPoint());
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    dragging = false;
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (anchor != null && target != null) {
                        fakePath = null;

                        shapes.add(makePath(anchor, e.getPoint(), target));

                        anchor = null;
                        target = null;

                        repaint();
                    }
                }
            });
        }

        protected Path2D makePath(Point p1, Point p2, Point p3) {
            Path2D p = new GeneralPath();
            p.moveTo(p1.getX(), p1.getY());
            p.curveTo(p1.getX(), p1.getY(),
                            p2.getX(), p2.getY(),
                            p3.getX(), p3.getY());

            return p;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
            g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
            g2d.setColor(Color.BLACK);
            for (Shape shape : shapes) {
                g2d.draw(shape);
            }
            if (anchor != null && target != null) {
                g2d.setColor(Color.GREEN);
                g2d.draw(new Line2D.Double(anchor, target));
            }
            if (fakePath != null) {
                g2d.setColor(Color.BLUE);
                g2d.draw(fakePath);
            }
            g2d.dispose();
        }

    }

}
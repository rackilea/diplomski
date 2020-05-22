import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class WheresMyMouse {

    public static void main(String[] args) {
        new WheresMyMouse();
    }

    public WheresMyMouse() {
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

        private double scale;
        private List<Rectangle> screenBounds;

        private Point virtualPoint;
        private Point screenPoint;

        public TestPane() {
            screenBounds = getScreenBounds();
            Timer timer = new Timer(40, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    PointerInfo pi = MouseInfo.getPointerInfo();
                    Point mp = pi.getLocation();
                    Rectangle bounds = getDeviceBounds(pi.getDevice());

                    screenPoint = new Point(mp);
                    virtualPoint = new Point(mp);
                    virtualPoint.x -= bounds.x;
                    virtualPoint.y -= bounds.y;
                    if (virtualPoint.x < 0) {
                        virtualPoint.x *= -1;
                    }
                    if (virtualPoint.y < 0) {
                        virtualPoint.y *= -1;
                    }
                    repaint();

                }
            });
            timer.start();
        }

        @Override
        public void invalidate() {
            super.invalidate();
            Rectangle virtualBounds = getVirtualBounds();
            scale = getScaleFactorToFit(virtualBounds.getSize(), getSize());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            int xOffset = 0;
            int yOffset = 0;
            List<Rectangle> scaledBounds = new ArrayList<>(screenBounds.size());
            for (Rectangle bounds : screenBounds) {
                bounds = scale(bounds);
                scaledBounds.add(bounds);
                if (bounds.x < xOffset) {
                    xOffset = bounds.x;
                }
                if (bounds.y < yOffset) {
                    yOffset = bounds.y;
                }
            }
            if (xOffset < 0) {
                xOffset *= -1;
            }
            if (yOffset < 0) {
                yOffset *= -1;
            }
            for (Rectangle bounds : scaledBounds) {
                bounds.x += xOffset;
                bounds.y += xOffset;
                g2d.setColor(Color.DARK_GRAY);
                g2d.fill(bounds);
                g2d.setColor(Color.GRAY);
                g2d.draw(bounds);
            }

            FontMetrics fm = g2d.getFontMetrics();

            g2d.setColor(Color.WHITE);
            if (screenPoint != null) {
                int x = 0;
                int y = fm.getAscent();

                g2d.drawString(screenPoint.toString(), x, y);
                screenPoint.x += xOffset;
                screenPoint.y += yOffset;
                screenPoint.x *= scale;
                screenPoint.y *= scale;
                g2d.fillOval(screenPoint.x - 2, screenPoint.y - 2, 4, 4);
            }

            if (virtualPoint != null) {
                int x = 0;
                int y = fm.getAscent() + fm.getHeight();

                g2d.drawString(virtualPoint.toString(), x, y);
            }

            g2d.dispose();
        }

        protected Rectangle scale(Rectangle bounds) {
            Rectangle scaled = new Rectangle(bounds);
            scaled.x *= scale;
            scaled.y *= scale;
            scaled.width *= scale;
            scaled.height *= scale;
            return scaled;
        }
    }

    public static Rectangle getScreenBoundsAt(Point pos) {
        GraphicsDevice gd = getGraphicsDeviceAt(pos);
        Rectangle bounds = null;
        if (gd != null) {
            bounds = gd.getDefaultConfiguration().getBounds();
        }
        return bounds;
    }

    public List<Rectangle> getScreenBounds() {

        List<Rectangle> bounds = new ArrayList<>(25);

        GraphicsDevice device = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();

        ArrayList<GraphicsDevice> lstDevices = new ArrayList<GraphicsDevice>(lstGDs.length);
        for (GraphicsDevice gd : lstGDs) {
            GraphicsConfiguration gc = gd.getDefaultConfiguration();
            Rectangle screenBounds = gc.getBounds();
            bounds.add(screenBounds);
        }

        return bounds;
    }

    public static Rectangle getDeviceBounds(GraphicsDevice device) {

        GraphicsConfiguration gc = device.getDefaultConfiguration();
        Rectangle bounds = gc.getBounds();
        return bounds;
    }

    public static GraphicsDevice getGraphicsDeviceAt(Point pos) {

        GraphicsDevice device = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();

        ArrayList<GraphicsDevice> lstDevices = new ArrayList<GraphicsDevice>(lstGDs.length);
        for (GraphicsDevice gd : lstGDs) {
            Rectangle screenBounds = getDeviceBounds(gd);
            if (screenBounds.contains(pos)) {
                lstDevices.add(gd);
            }
        }
        if (lstDevices.size() == 1) {
            device = lstDevices.get(0);
        }

        return device;

    }

    public static Rectangle getVirtualBounds() {

        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            bounds.add(getDeviceBounds(gd));
        }
        return bounds;

    }

    public static double getScaleFactor(int iMasterSize, int iTargetSize) {

        double dScale = 1;
        dScale = (double) iTargetSize / (double) iMasterSize;

        return dScale;

    }

    public static double getScaleFactorToFit(Dimension original, Dimension toFit) {

        double dScale = 1d;
        if (original != null && toFit != null) {
            double dScaleWidth = getScaleFactor(original.width, toFit.width);
            double dScaleHeight = getScaleFactor(original.height, toFit.height);
            dScale = Math.min(dScaleHeight, dScaleWidth);
        }
        return dScale;

    }

}
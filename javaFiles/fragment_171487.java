import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.geom.*;
import java.awt.*;
import java.util.*;

class MyCanvas extends JComponent {
    int a, supb, b, c, length, r;
    double x1, y1, x2, y2, x3, y3;
    Random random = new Random();

    public MyCanvas() {
            a = random.nextInt(80 - 30) + 30;
            supb = random.nextInt(120 - 70) + 100;
            b = 180 - supb;
            c = 180 - a - b;
            length = random.nextInt(150 - 100) + 100;
            x1 = 0;
            y1 = 0;
            r = 20;
            x2 = x1 + length;
            y2 = y1;
            x3 = (x1 + Math.cos(Math.toRadians(-a)) * length);
            y3 = (y1 + Math.sin(Math.toRadians(-a)) * length);
    }

    public void paintComponent(Graphics g2) {
            float dx1, dy1, ang1, dx2, dy2, ang2, ang3;
            Graphics2D g = (Graphics2D) g2;
            AffineTransform oldt = g.getTransform();

            Shape shape = getTriangle(x1, y1, x2, y2, x3, y3);

            Rectangle2D bounds = shape.getBounds2D();

            double height = bounds.getHeight();
            double width = bounds.getWidth();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
            g.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT,
                            BasicStroke.JOIN_BEVEL));
            g.translate((this.getWidth() - width) / 2,
                            (this.getHeight() - height) / 2);
            g.translate(-bounds.getX(), -bounds.getY());

            dy1 = (float) (y3 - y1);
            dx1 = (float) (x3 - x1);
            ang1 = (float) (Math.atan((float)(dy1 / dx1)) * 180 / Math.PI);

            ang1 = (float) Math.abs(ang1);

            dy2 = (float) (y2 - y3);
            dx2 = (float) (x2 - x3);
            ang2 = (float) (Math.atan((float)(dy2 / dx2)) * 180 / Math.PI);

            ang2 = (float) Math.abs(ang2);

    ang3 = (float) (180-ang2-ang1);

            g.setColor(Color.BLACK);
            g.draw(shape);
            g.setColor(Color.RED);
            g.draw(new Arc2D.Double(x1 - r, y1 - r, 2 * r, 2 * r, 0, ang1, Arc2D.OPEN));
            g.setColor(Color.GREEN);
            g.draw(new Arc2D.Double(x2 - r, y2 - r, 2 * r, 2 * r, (180 - ang2), ang2,
                            Arc2D.OPEN));
            g.setColor(Color.RED);
            g.draw(new Arc2D.Double(x3 - r, y3 - r, 2 * r, 2 * r, -180 + a, ang3,
                            Arc2D.OPEN));
            g.setTransform(oldt);
    }

    private Shape getTriangle(double x1, double y1, double x2, double y2,
                    double x3, double y3) {
            GeneralPath gp = new GeneralPath();
            gp.moveTo(x1, y1);
            gp.lineTo(x2, y2);
            gp.lineTo(x3, y3);
            gp.closePath();
            return gp;
    }
}

public class TrianglePanel {
        public static void main(String[] a) {
                JFrame window = new JFrame();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.setBounds(30, 30, 300, 300);
                window.getContentPane().add(new MyCanvas());
                window.setVisible(true);
        }
}
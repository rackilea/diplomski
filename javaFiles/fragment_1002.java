import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AffineTransformFromPoints
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AffineTransformFromPointsPanel panel = 
            new AffineTransformFromPointsPanel();
        f.getContentPane().setLayout(new BorderLayout());
        f.getContentPane().add(panel, BorderLayout.CENTER);
        f.setSize(1200,900);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}

class AffineTransformFromPointsPanel extends JPanel 
    implements MouseListener, MouseMotionListener
{
    private Point2D draggedPoint;

    // the position of the points before the transformation
    Point2D[] src = new Point2D[] {
        new Point2D.Double(486, 191),
        new Point2D.Double(456, 565),
        new Point2D.Double(149, 353)
    };

    // the position of the points after the transformation
    Point2D[] dst = new Point2D[] {
        new Point2D.Double(0, 0),
        new Point2D.Double(0, 600),
        new Point2D.Double(600, 600)
    };


    public AffineTransformFromPointsPanel()
    {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.RED);
        for (Point2D v : src)
        {
            paint(g, v);
        }

        g.setColor(Color.GREEN);
        for (Point2D v : dst)
        {
            paint(g, v);
        }

        g.setColor(Color.BLUE);
        AffineTransform at = computeTransform(src, dst);
        for (Point2D v : src)
        {
            draw(g, v, at);
        }
    }

    private static AffineTransform computeTransform(
        Point2D src[], Point2D dst[])
    {
        AffineTransform unitToSrc = computeTransform(src[0], src[1], src[2]);
        AffineTransform unitToDst = computeTransform(dst[0], dst[1], dst[2]);
        AffineTransform srcToUnit = null;
        try
        {
            srcToUnit = unitToSrc.createInverse();
        }
        catch (NoninvertibleTransformException e)
        {
            System.out.println(e.getMessage());
            return new AffineTransform();
        }
        AffineTransform at = new AffineTransform();
        at.concatenate(unitToDst);
        at.concatenate(srcToUnit);
        return at;
    }

    private static AffineTransform computeTransform(
        Point2D p0, Point2D p1, Point2D p2)
    {
        AffineTransform at = new AffineTransform();
        double dx1 = p1.getX() - p0.getX();
        double dy1 = p1.getY() - p0.getY();
        double dx2 = p2.getX() - p0.getX();
        double dy2 = p2.getY() - p0.getY();
        at.setTransform(dx1, dy1, dx2, dy2, p0.getX(), p0.getY());
        return at;
    }

    private static void paint(Graphics2D g, Point2D p)
    {
        double r = 6;
        g.fill(new Ellipse2D.Double(
            p.getX() - r, p.getY() - r, r + r, r + r));
    }

    private static void draw(Graphics2D g, Point2D v, AffineTransform at)
    {
        double r = 8;
        Point2D p = new Point2D.Double(v.getX(), v.getY());
        at.transform(p, p);
        g.draw(new Ellipse2D.Double(
            p.getX() - r, p.getY() - r, r + r, r + r));
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if (draggedPoint != null)
        {
            draggedPoint.setLocation(e.getPoint());
            repaint();
        }
    }


    @Override
    public void mousePressed(MouseEvent e)
    {
        draggedPoint = closest(e.getPoint(), Arrays.asList(src));
        if (draggedPoint == null)
        {
            draggedPoint = closest(e.getPoint(), Arrays.asList(dst));
        }
    }

    private static Point2D closest(
        Point2D p, Iterable<? extends Point2D> points)
    {
        final double threshold = 10;
        Point2D closestPoint = null;
        double minDistance = Double.MAX_VALUE;

        for (Point2D point : points)
        {
            double dd = point.distance(p);
            if (dd < threshold && dd < minDistance)
            {
                minDistance = dd;
                closestPoint = point;
            }
        }
        return closestPoint;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        draggedPoint = null;
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        // Nothing to do here
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        // Nothing to do here
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        // Nothing to do here
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        // Nothing to do here
    }

}
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ShapeOverlap
{
    public static void main(String[] args) throws IOException
    {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new ShapeOverlapPanel());
        f.setSize(900,500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

class ShapeOverlapPanel extends JPanel
    implements MouseListener, MouseMotionListener
{
    private final List<Point2D> points0;
    private final List<Point2D> points1;
    private final List<Point2D> draggedPoints;
    private Point previousMousePosition;

    ShapeOverlapPanel()
    {
        points0 = new ArrayList<Point2D>();
        points0.add(new Point2D.Double(160, 200));
        points0.add(new Point2D.Double(180, 200));
        points0.add(new Point2D.Double(270, 260));
        points0.add(new Point2D.Double(250, 260));

        points1 = new ArrayList<Point2D>();
        points1.add(new Point2D.Double(200, 280));
        points1.add(new Point2D.Double(220, 280));
        points1.add(new Point2D.Double(310, 340));
        points1.add(new Point2D.Double(290, 340));

        draggedPoints = new ArrayList<Point2D>();

        addMouseListener(this);
        addMouseMotionListener(this);
    }


    @Override
    protected void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Graphics2D g = (Graphics2D)gr;
        g.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,  
            RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        Shape s0 = createShape(points0);        
        Shape s1 = createShape(points1);

        g.setColor(Color.RED);
        g.fill(s0);
        g.setColor(Color.BLUE);
        g.fill(s1);

        g.setColor(Color.GRAY);
        drawOverlap(g, s0, s1);

        double overlap = computeOverlap(s0, s1);
        g.drawString("Overlap of red from blue: "+overlap, 10, 20);
    }

    private static double computeOverlap(Shape s0, Shape s1)
    {
        Rectangle2D b0 = s0.getBounds2D();
        Rectangle2D b1 = s1.getBounds2D();

        if (b0.getMaxX() < b1.getMinX())
        {
            System.out.println("Shape 0 is left of shape 1");
            return Double.NaN;
        }
        if (b0.getMinX() > b1.getMaxX())
        {
            System.out.println("Shape 0 is right of shape 1");
            return Double.NaN;
        }

        double overlapMinX = Math.max(b0.getMinX(), b1.getMinX());
        double overlapMaxX = Math.min(b0.getMaxX(), b1.getMaxX());
        double overlapSize = overlapMaxX - overlapMinX;

        double relativeOverlap = overlapSize / b0.getWidth();
        return relativeOverlap;
    }

    private void drawOverlap(Graphics2D g, Shape s0, Shape s1)
    {
        Rectangle2D b0 = s0.getBounds2D();
        Rectangle2D b1 = s1.getBounds2D();

        if (b0.getMaxX() < b1.getMinX())
        {
            return;
        }
        if (b0.getMinX() > b1.getMaxX())
        {
            return;
        }

        double overlapMinX = Math.max(b0.getMinX(), b1.getMinX());
        double overlapMaxX = Math.min(b0.getMaxX(), b1.getMaxX());

        g.drawLine((int)overlapMinX, 0, (int)overlapMinX, getHeight());
        g.drawLine((int)overlapMaxX, 0, (int)overlapMaxX, getHeight());
    }


    private static Shape createShape(Iterable<? extends Point2D> points)
    {
        Path2D path = new Path2D.Double();
        boolean first = true;
        for (Point2D p : points)
        {
            if (first)
            {
                path.moveTo(p.getX(), p.getY());
                first = false;
            }
            else
            {
                path.lineTo(p.getX(), p.getY());
            }
        }
        path.closePath();
        return path;
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        int dx = e.getX() - previousMousePosition.x;
        int dy = e.getY() - previousMousePosition.y;
        for (Point2D p : draggedPoints)
        {
            p.setLocation(p.getX() + dx, p.getY() + dy);
        }
        repaint();
        previousMousePosition = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        draggedPoints.clear();
        Shape s0 = createShape(points0);
        Shape s1 = createShape(points1);
        if (s0.contains(e.getPoint()))
        {
            draggedPoints.addAll(points0);
        }
        else if (s1.contains(e.getPoint()))
        {
            draggedPoints.addAll(points1);
        }
        previousMousePosition = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        draggedPoints.clear();
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }


}
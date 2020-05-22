import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawLine extends JPanel implements MouseListener,
                MouseMotionListener {

    Point startDrag, endDrag;

    public DrawLine() {

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public static void main(String[] args) {
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
                frame.add(new DrawLine());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    Shape r = null;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(1));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                        0.50f));

        if (startDrag != null && endDrag != null) {
            System.out.println(startDrag + " - " + endDrag);
            r = makeLine(startDrag.x, startDrag.y, endDrag.x,
                            endDrag.y);
        }

        if (r != null) {
            g2.draw(r);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        endDrag = new Point(e.getPoint());
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent me) {
//        startDrag = new Point(me.getX(), me.getY());
//        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent me) {
        startDrag = new Point(me.getPoint());
        repaint();

    }

    private Line2D.Float makeLine(int x1, int y1, int x2, int y2) {
        return new Line2D.Float(x1, y1, x2, y2);
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        r = makeLine(startDrag.x, startDrag.y, me.getX(), me.getY());

        startDrag = null;
        endDrag = null;
        repaint();

    }
}
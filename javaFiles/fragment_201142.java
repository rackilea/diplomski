import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList; 
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorkingLines {

    public WorkingLines() {

        JFrame jf = new JFrame("Free Hand Drawing Example");
        JPanel draw = new DrawBoard();
        jf.add(new Label("Click....move mouse, click again"), BorderLayout.NORTH);
        jf.add(draw);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600, 500);
        jf.setVisible(true);
    }

    public static void main(String a[]) {
        new WorkingLines();
    }
}

class DrawBoard extends JPanel implements MouseListener, MouseMotionListener {
    ArrayList<pts> list = new ArrayList<>();
    Point start, end;
    private boolean isDrawing = false; //a flag

    public DrawBoard() {
        start = null;  end = null; /* Initializing */
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        super.paintComponent(g2);

        for (pts p : list) {
            g.drawLine((int) p.getStart().getX(), (int) p.getStart().getY(), (int) p.getEnd().getX(),
                    (int) p.getEnd().getY());
        }

        if ((start != null) && (end != null)) {
            g.drawLine(start.x, start.y, end.x, end.y);
        }
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {}

    @Override
    public void mouseEntered(MouseEvent arg0) {}

    @Override
    public void mouseExited(MouseEvent arg0) {}

    @Override
    public void mousePressed(MouseEvent me) {

        if(! isDrawing) {

            start = me.getPoint();
            isDrawing = ! isDrawing;
        }else {

            pts pt = new pts(start, end);
            list.add(pt);
            start = end;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {

        if (me.getClickCount() == 2) {
            start = null;
            end = null;
            isDrawing = false;
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {}

    @Override
    public void mouseMoved(MouseEvent me) {
            end = me.getPoint();
            repaint();
    }
}

class pts {

    Point start = null, end = null;

    public pts(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start;   }

    public Point getEnd() {  return end;  }
}
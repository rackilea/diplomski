import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouse extends MouseAdapter {
    private Point p1;

    @Override
    public void mousePressed(MouseEvent e) {
        p1 = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (p1 != null) {
            createRect(e);
        }
    }

    private void createRect(MouseEvent e) {
        Point p2 = e.getPoint();
        int x = Math.min(p1.x, p2.x);
        int y = Math.min(p1.y, p2.y);
        int width = Math.abs(p1.x - p2.x);
        int height = Math.abs(p1.y - p2.y);

        Rectangle r = new Rectangle(x, y, width, height);
        ((DrawingPanel) e.getSource()).setRectangle(r);
        ((DrawingPanel) e.getSource()).repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (p1 != null) {
            createRect(e);
        }
        p1 = null;
    }
}
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResizeRectangle extends JPanel {
  private int SIZE = 8;
  //Below are 3 points, points[0] and [1] and top-left and bottom-right of the shape.
  // points[2] is the center of the shape
  private Rectangle2D[] points = { new Rectangle2D.Double(50, 50,SIZE, SIZE), 
                                   new Rectangle2D.Double(150, 100,SIZE, SIZE),
                                   new Rectangle2D.Double(100, 75,SIZE, SIZE)};
  Ellipse2D s = new Ellipse2D.Double();

  ShapeResizeHandler ada = new ShapeResizeHandler();

  public ResizeRectangle() {
    addMouseListener(ada);
    addMouseMotionListener(ada);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D) g;

    for (int i = 0; i < points.length; i++) {
      g2.fill(points[i]);
    }
    s.setFrame(points[0].getCenterX(), points[0].getCenterY(),
        Math.abs(points[1].getCenterX()-points[0].getCenterX()),
        Math.abs(points[1].getCenterY()- points[0].getCenterY()));
    g2.draw(s);
  }

  class ShapeResizeHandler extends MouseAdapter {

    private Point2D[] lastPoints = new Point2D[3];
    private int pos = -1;
    public void mousePressed(MouseEvent event) {
      Point p = event.getPoint();

      for (int i = 0; i < points.length; i++) {
        if (points[i].contains(p)) {
          pos = i;
          // initialize preDrag points
          for(int j = 0; j < 3; j++){
              lastPoints[j] = new Point2D.Double(points[j].getX(), points[j].getY());
          }
          return;
        }
      }
    }

    public void mouseReleased(MouseEvent event) {
      pos = -1;
    }

    public void mouseDragged(MouseEvent event) {
      if (pos == -1)
        return;
      if(pos != 2){ //if 2, it's a shape drag
          points[pos].setRect(event.getPoint().x,event.getPoint().y,points[pos].getWidth(),
              points[pos].getHeight());
          int otherEnd = (pos==1)?2:1; //Get the end other than what is being dragged (top-left or bottom-right)
          //Get the x,y of the centre of the line joining the 2 new diagonal vertices, which will be new points[2]
          double newPoint2X = points[otherEnd].getX() + (points[pos].getX() - points[otherEnd].getX())/2;
          double newPoint2Y = points[otherEnd].getY() + (points[pos].getY() - points[otherEnd].getY())/2;
          points[2].setRect(newPoint2X, newPoint2Y, points[2].getWidth(), points[2].getHeight());
      }
      else{ //Shape drag, 1,2,3 points/marker rects need to move equal amounts
          Double deltaX = event.getPoint().x - lastPoints[2].getX();
          Double deltaY = event.getPoint().y - lastPoints[2].getY();
          for(int j = 0; j < 3; j++)
              points[j].setRect((lastPoints[j].getX() + deltaX),(lastPoints[j].getY() + deltaY),points[j].getWidth(),
                  points[j].getHeight());

      }
      repaint();
    }
  }

  public static void main(String[] args) {

    JFrame frame = new JFrame("Resize Shape2D");

    frame.add(new ResizeRectangle());
    frame.setSize(300, 300);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
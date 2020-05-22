import java.awt.Dimension;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author LLASPINA
*/
public class CirclePanel extends JPanel implements ActionListener {

  Timer timer;
  private int prefwid, prefht;
  ArrayList<Circle> circleList;

  public CirclePanel(int pwid, int pht) {
     prefwid = pwid;
     prefht = pht;
     createCircles();
     timer = new Timer(300, this);
     timer.start();
  }

  public void createCircles() {
     circleList = new ArrayList<Circle>();
     for (int i = 1; i <= 20; i++) {
        Circle nextCircle = new Circle();
        circleList.add(nextCircle);
     }
  }

  public Dimension getPreferredSize() {
     return new Dimension(prefwid, prefht);
  }

  public void paintComponent(Graphics g) {
     super.paintComponent(g);
     Graphics2D g2d = (Graphics2D) g;
     for (Circle c : circleList) {
        c.draw(g2d);
     }

  }

  public static void main(String[] args) {
     JFrame frame = new JFrame();
     CirclePanel panel = new CirclePanel(400,500);
     frame.add(panel);
     frame.setSize(400,500);
     //frame.pack();
     frame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
     //move those circles and then redraw them.
  }
  class Circle {

     int x, y;
     int radius;

     public Circle() {
        this.x = (int) (Math.random() * (prefwid-10));
        this.y = (int) (Math.random() * (prefht-10));
        this.radius = (int) (Math.random() * 50) + 10;
     }

     public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.radius = r;
     }

     public void draw(Graphics2D g) {
        g.drawOval(x, y, radius, radius);
     }
  }   
}
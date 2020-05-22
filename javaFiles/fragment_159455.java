import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

@SuppressWarnings("serial")
public class GameApplet2 extends JApplet {
   protected static final int APP_WIDTH = 1000;
   protected static final int APP_HEIGHT = 900;

   @Override
   public void init() {
      try {
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               GameAppletPanel panel = new GameAppletPanel(GameApplet2.this);
               getContentPane().add(panel);
               panel.init(APP_WIDTH, APP_HEIGHT);
               setSize(APP_WIDTH, APP_HEIGHT);
            }
         });
      } catch (InterruptedException e) {
         e.printStackTrace();
      } catch (InvocationTargetException e) {
         e.printStackTrace();
      }
   }
}

@SuppressWarnings("serial")
class GameAppletPanel extends JPanel {
   Image image;
   Point p = new Point(-100, -100);
   private JApplet applet;

   public GameAppletPanel(JApplet applet) {
      this.applet = applet;
   }

   public void init() {
      init(1000, 900);
   }

   public void init(int x, int y) {
      setSize(x, y);
      image = createImage(x, y);
      Graphics2D g = (Graphics2D) image.getGraphics();
      g.setColor(Color.GREEN);
      g.fillRect(0, 0, x, y);
      g.dispose();

      System.out.println(g + ", " + (g != null));
      MyMouseAdapter mmAdapter = new MyMouseAdapter();
      addMouseListener(mmAdapter);
      addMouseMotionListener(mmAdapter);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(image, 0, 0, this);
      g.setColor(Color.red);
      g.fillRect(0, 0, 500, 500);
   }

   private class MyMouseAdapter extends MouseAdapter {

      @Override
      public void mouseClicked(MouseEvent e) {
         System.out.println(e);
      }

      @Override
      public void mousePressed(MouseEvent e) {
         p = e.getPoint();
         repaint();
      }

      @Override
      public void mouseMoved(MouseEvent e) {
         applet.showStatus(e.toString());
         Graphics2D g2 = (Graphics2D) image.getGraphics();
         g2.fillOval(e.getPoint().x - 5, e.getPoint().y - 5, 10, 10);
         p = e.getPoint();
         g2.dispose();
         repaint();
      }
   }

}
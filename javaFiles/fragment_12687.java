import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class MyPanel extends JPanel {
   private GraphicsEnvironment ge;
   private GraphicsDevice gs;
   private GraphicsConfiguration gc;
   private BufferedImage offScreen;

   public MyPanel(boolean visible) {
      super();
      this.setLayout(new BorderLayout(640, 416)); // strange constants for this layout.
      this.setOpaque(false);
      this.setVisible(visible);
      ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      gs = ge.getDefaultScreenDevice();
      gc = gs.getDefaultConfiguration();

      addComponentListener(new ComponentAdapter() {
         @Override
         public void componentResized(ComponentEvent e) {
            setUp();
         }
      });
   }

   @Override
   // don't make this public. Keep it protected like the super's
   // just draw in this method. Don't call other methods that create buffers
   // or draw to buffers.
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (offScreen != null) {
         g.drawImage(offScreen, 0, 0, null);
      }
   }

   private void setUp() {
      offScreen = gc.createCompatibleImage(getSize().width, getSize().height,
            Transparency.TRANSLUCENT);
   }

   // draw to the buffer outside of the paintComponent
   // and then call repaint() when done
   public void upDateOffScreen() {
      // ?? offScreen.flush(); // I've never used this before, 
                  // so am not sure if you need this here
      Graphics2D osGraphics = offScreen.createGraphics();
      // TODO: do drawing with osGraphics object here
      osGraphics.dispose();
      repaint();
   }
}
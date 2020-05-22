import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class G {
  public static final int PREF_W = 400;
  public static final int PREF_H = PREF_W;

public static void main (String [] args) {
    JFrame frame = new JFrame(G.class.getCanonicalName());
    frame.setUndecorated(true);
    JComponent component = new JComponent() {
      private static final long serialVersionUID = 1L;
      @Override
      protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        AffineTransform tform = AffineTransform.getTranslateInstance( 0, getHeight());
        tform.scale( 1, -1);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setTransform( tform);
        paint2D(g2);
        g2.dispose();
      }
      protected void paint2D (Graphics2D g2) {
        g2.draw(new Rectangle2D.Double(10, 10, 20, 30));
      }

      @Override
      public Dimension getPreferredSize() {
         return new Dimension(PREF_W, PREF_H);
      }
    };
    frame.add(component);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
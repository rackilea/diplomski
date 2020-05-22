import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Foo002 {
   private static final int WIDTH = 20;

   public static void main(String[] args) {
      BufferedImage img = new BufferedImage(WIDTH, WIDTH,
            BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      int[] xPoints = { WIDTH / 3, (2 * WIDTH) / 3, WIDTH / 3 };
      int[] yPoints = { 0, WIDTH / 2, WIDTH };
      g2.setColor(Color.black);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setRenderingHint(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
      g2.fillPolygon(xPoints, yPoints, xPoints.length);
      g2.dispose();

      ImageIcon icon = new ImageIcon(img);
      JLabel label = new JLabel(icon);
      label.setBorder(BorderFactory.createLineBorder(Color.black));
      JPanel panel = new JPanel();
      panel.add(label);

      JOptionPane.showMessageDialog(null, panel);
   }
}
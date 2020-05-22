import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GraphicExample extends JPanel {
   private static final String IMG_FILE_PATH = "/media/01CCE00FA6888D80/" +
        "Achieve/Eclipse/EmiloLadderSnack/src/photo.jpg";
   private BufferedImage img;

   public GraphicExample(BufferedImage img) {
      this.img = img;
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (img != null) {
         g.drawImage(img, 0, 0, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      if (img != null) {
         return new Dimension(img.getWidth(), img.getHeight());
      }
      return super.getPreferredSize();
   }

   private static void createAndShowGui() {
      try {
         BufferedImage img = ImageIO.read(new File(IMG_FILE_PATH));
         JFrame frame = new JFrame("GraphicExample");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(new GraphicExample(img));
         frame.pack();
         frame.setLocationRelativeTo(null);
         frame.setVisible(true);

         // the easy way to display an image -- in a JLabel:
         ImageIcon icon = new ImageIcon(img);
         JLabel label = new JLabel(icon);
         JOptionPane.showMessageDialog(frame, label);

      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ChangingImages extends JPanel {
   public static final String SPRITE_SHEET_PATH = "http://i.stack.imgur.com/SeZ5y.png";
   private static final int DELAY = 400;
   private List<Icon> imageIconList = new ArrayList<>();
   private JLabel label = new JLabel();

   public ChangingImages() throws IOException {
      URL imgUrl = new URL(SPRITE_SHEET_PATH);
      BufferedImage img = ImageIO.read(imgUrl); 
      for (int i = 0; i < 2; i++) {
         for (int j = 0; j < 6; j++) {
            int x = (img.getWidth() * j) / 6;
            int y = (img.getHeight() * i) / 2;
            int w = img.getWidth() / 6;
            int h = img.getHeight() / 2;
            BufferedImage subImg = img.getSubimage(x, y, w, h);
            imageIconList.add(new ImageIcon(subImg));            
         }
      }

      add(label);
      label.setIcon(imageIconList.get(0));

      new Timer(DELAY, new ActionListener() {
         int index = 0;
         @Override
         public void actionPerformed(ActionEvent e) {
            index++;
            index %= imageIconList.size();
            label.setIcon(imageIconList.get(index));
         }
      }).start();
   }

   private static void createAndShowGui() {
      ChangingImages mainPanel = null;
      try {
         mainPanel = new ChangingImages();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("ChangingImages");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}
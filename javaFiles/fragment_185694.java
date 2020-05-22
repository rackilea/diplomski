import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyGui extends JPanel {
   public static final String IMAGE_PATH = "https://duke.kenai.com/cards/.Midsize/CardFaces.png.png";
   private static final int ROWS = 4;
   private static final int COLS = 13;
   private BufferedImage largeImg;
   private List<ImageIcon> iconList = new ArrayList<>();
   private JLabel pictureLabel = new JLabel();
   private JButton swapPictureBtn = new JButton(new SwapPictureAction(this, "Swap Picture"));
   private int iconIndex = 0;

   public MyGui() throws IOException {
      add(pictureLabel);
      add(swapPictureBtn);

      URL imgUrl = new URL(IMAGE_PATH);
      largeImg = ImageIO.read(imgUrl);
      for (int i = 0; i < ROWS; i++) {
         for (int j = 0; j < COLS; j++) {
            int x = (j * largeImg.getWidth()) / COLS;
            int y = (i * largeImg.getHeight()) / ROWS;
            int w = largeImg.getWidth() / COLS;
            int h = largeImg.getHeight() / ROWS;
            iconList.add(new ImageIcon(largeImg.getSubimage(x, y, w, h)));
         }
      }

      pictureLabel.setIcon(iconList.get(iconIndex));
   }

   public void swapPicture() {
      iconIndex++;
      iconIndex %= iconList.size();
      pictureLabel.setIcon(iconList.get(iconIndex));
   }

   private static void createAndShowGui() {
      MyGui mainPanel;
      try {
         mainPanel = new MyGui();
         JFrame frame = new JFrame("MyGui");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.getContentPane().add(mainPanel);
         frame.pack();
         frame.setLocationByPlatform(true);
         frame.setVisible(true);

      } catch (IOException e) {
         e.printStackTrace();
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

@SuppressWarnings("serial")
class SwapPictureAction extends AbstractAction {

   private MyGui myGui;

   public SwapPictureAction(MyGui myGui, String name) {
      super(name);
      this.myGui = myGui;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      myGui.swapPicture();
   }
}
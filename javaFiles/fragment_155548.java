import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class RandomChessMen extends JPanel {
   // for this example I get a sprite sheet that holds several sprite images in it
   // the images can be found here: http://stackoverflow.com/questions/19209650
   private static final String IMAGE_PATH = "http://i.stack.imgur.com/memI0.png";
   private static final int LABEL_COUNT = 2;
   private static final int ICON_COLUMNS = 6;
   private Random random = new Random();

   public RandomChessMen() throws IOException {
      URL url = new URL(IMAGE_PATH);
      BufferedImage largeImg = ImageIO.read(url);
      setLayout(new GridLayout(1, 0));

      // break down large image into its constituent sprites and place into ArrayList<Icon>
      int w = largeImg.getWidth() / ICON_COLUMNS;
      int h = largeImg.getHeight() / LABEL_COUNT;
      for (int i = 0; i < LABEL_COUNT; i++) {
         final List<Icon> iconList = new ArrayList<>();
         int y = (i * largeImg.getHeight()) / LABEL_COUNT;
         // get 6 icons out of large image
         for (int j = 0; j < ICON_COLUMNS; j++) {
            int x = (j * largeImg.getWidth()) / ICON_COLUMNS;
            // get subImage
            BufferedImage subImg = largeImg.getSubimage(x, y, w, h);
            // create ImageIcon and add to list
            iconList.add(new ImageIcon(subImg));
         }

         // create JLabel
         final JLabel label = new JLabel("", SwingConstants.CENTER);
         int eb = 40;
         label.setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));

         // get random index for iconList
         int randomIndex = random.nextInt(iconList.size());
         Icon icon = iconList.get(randomIndex); // use index to get random Icon
         label.setIcon(icon); // set label's icon
         label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
               Icon secondIcon = label.getIcon();
               // so we don't repeat icons
               while (label.getIcon() == secondIcon) {
                  int randomIndex = random.nextInt(iconList.size());
                  secondIcon = iconList.get(randomIndex);
               }
               label.setIcon(secondIcon);
            }
         });
         // add to GUI
         add(label);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("RandomImages");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      try {
         frame.getContentPane().add(new RandomChessMen());
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
      frame.pack();
      frame.setLocationRelativeTo(null);
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
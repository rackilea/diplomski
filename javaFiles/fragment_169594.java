import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class SpriteAnimationApplet extends JApplet {
   private static final String SPRITE_SHEET_SPEC = "http://www.funorb.com/img/images/game/"
         + "central/dev_diary/sprite_sheet_full.gif";
   private static final int SPRITE_ROWS = 8; // an 8 x 8 sprite sheet

   @Override
   public void init() {
      try {
         final Icon[] icons = SpriteIO.getSprites(SPRITE_SHEET_SPEC, SPRITE_ROWS);
         SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
               SpriteAnimationPanel spritePanel = new SpriteAnimationPanel(icons);
               getContentPane().add(spritePanel);
               spritePanel.startAnimation();
            }
         });
      } catch (InvocationTargetException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (InterruptedException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (MalformedURLException e) {
         e.printStackTrace();
         System.exit(-1);
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }
   }

}

class SpriteIO {
   public static Icon[] getSprites(String spriteSheetSpec, int spriteRows)
         throws MalformedURLException, IOException {
      Icon[] icons = new Icon[spriteRows * spriteRows];
      URL spriteSheetUrl = new URL(spriteSheetSpec);
      BufferedImage spriteSheet = ImageIO.read(spriteSheetUrl);
      double wD = (double) spriteSheet.getWidth() / spriteRows;
      double hD = (double) spriteSheet.getHeight() / spriteRows;
      int w = (int) wD;
      int h = (int) hD;
      for (int i = 0; i < spriteRows; i++) {
         for (int j = 0; j < spriteRows; j++) {
            int x = (int) (i * wD);
            int y = (int) (j * hD);
            BufferedImage img = spriteSheet.getSubimage(x, y, w, h);

            icons[j * spriteRows + i] = new ImageIcon(img);
         }
      }
      return icons;
   }
}

@SuppressWarnings("serial")
class SpriteAnimationPanel extends JPanel {
   private static final int TIMER_DELAY = 200;
   private Icon[] icons;
   private JLabel animationLabel = new JLabel();

   public SpriteAnimationPanel(Icon[] icons) {
      this.icons = icons;
      setLayout(new BorderLayout());
      add(animationLabel );
   }

   public void startAnimation() {
      Timer spriteTimer = new Timer(TIMER_DELAY, new ActionListener() {
         private int iconIndex = 0;

         @Override
         public void actionPerformed(ActionEvent arg0) {
            animationLabel.setIcon(icons[iconIndex]);
            iconIndex++;
            iconIndex %= icons.length;
         }
      });
      spriteTimer.start();
   }
}
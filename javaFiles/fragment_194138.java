import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class TimerEg extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   private static final String ICON_PATH = "https://duke.kenai.com/iconSized/duke4.gif";
   private static final int TIMER_DELAY = 400;

   private BufferedImage imageSprite = null;
   private Random random = new Random();
   private int finalX;
   private int finalY;

   public TimerEg() throws IOException {
      URL imgUrl = new URL(ICON_PATH);
      imageSprite = ImageIO.read(imgUrl);

      int maxX = PREF_W - imageSprite.getWidth();
      int maxY = PREF_H - imageSprite.getHeight();
      new Timer(TIMER_DELAY, new TimerListener(this, maxX, maxY)).start();
   }

   public void setSpriteLocation(int x, int y) {
      finalX = x;
      finalY = y;
      repaint();
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (imageSprite != null) {
         g.drawImage(imageSprite, finalX, finalY, this);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class TimerListener implements ActionListener {
      private TimerEg timerEg;
      private int maxX;
      private int maxY;

      private TimerListener(TimerEg timerEg, int maxX, int maxY) {
         this.timerEg = timerEg;
         this.maxX = maxX;
         this.maxY = maxY;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         int currentX = random.nextInt(maxX);
         int currentY = random.nextInt(maxY);
         timerEg.setSpriteLocation(currentX, currentY);
      }
   }

   private static void createAndShowGui() {
      TimerEg mainPanel = null;
      try {
         mainPanel = new TimerEg();
      } catch (IOException e) {
         e.printStackTrace();
         System.exit(-1);
      }

      JFrame frame = new JFrame("TimerEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.IOException;
import java.net.URL;
import java.lang.String;
import java.awt.Font;

@SuppressWarnings("serial")
public class SpaceShip extends JPanel {
   private static final String BACKGROUND_PATH = "http://www.thatsreallypossible.com/"
         + "wp-content/uploads/2012/12/Space-Colonialisation.jpg";
   private static final String SPRITE_PATH = "http://www.pd4pic.com/"
         + "images250_/ufo-flying-saucer-spacecraft-spaceship-alien.png";

   private Font font1;
   int myX = 100;
   int myY = 400;
   int count = 0;
   private BufferedImage background;
   private BufferedImage sprite;

   public SpaceShip() throws IOException {
      URL backgroundUrl = new URL(BACKGROUND_PATH);
      URL spriteUrl = new URL(SPRITE_PATH);
      background = ImageIO.read(backgroundUrl);
      sprite = ImageIO.read(spriteUrl);

      MouseAdapter myMouseAdapter = new MouseAdapter() {
         public void mousePressed(MouseEvent evt) {
            moveIt(evt);
            count = count + 1;
         }

         @Override
         public void mouseDragged(MouseEvent evt) {
            moveIt(evt);
         }
      };
      addMouseListener(myMouseAdapter);
      addMouseMotionListener(myMouseAdapter);
   }

   @Override
   public Dimension getPreferredSize() {
      if (background != null) {
         return new Dimension(background.getWidth(), background.getHeight());
      }
      return super.getPreferredSize();
   }

   public void moveIt(MouseEvent evt) {
      myY = evt.getY() - sprite.getHeight() / 2;
      myX = evt.getX() - sprite.getWidth() / 2;
      repaint();
   }


   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      font1 = new Font("Serif", Font.BOLD, 36);
      g.drawImage(background, 0, 0, this);
      g.drawImage(sprite, myX, myY, this);
      g.setColor(Color.yellow);
      int rectCount = 10;
      int height = getHeight() / rectCount;
      int width = 272;
      int x = getWidth() - width;
      for (int i = 0; i < rectCount; i++) {
         int y = i * height;
         g.drawRect(x, y, width, height);
      }
      g.setFont(font1);
      g.drawString(Integer.toString(count), 500, 100);
   }

   public static void main(String[] args) {
      JFrame frame = new JFrame("Basic Game");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      SpaceShip ex;
      try {
         ex = new SpaceShip();
         frame.getContentPane().add(ex);
         frame.pack();
         frame.setResizable(false);
         frame.setVisible(true);
         ex.requestFocus();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
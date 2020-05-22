import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Game2 extends JPanel {
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;
   private static final int TIMER_DELAY = 50;
   private static final int DELTA_WIDTH = 50;
   private static final Color HELLO_COLOR = new Color(150, 150, 255);
   private int delta = 0;
   private BufferedImage img;

   public Game2() {
      img = createMyImage();
      setBackground(Color.BLACK);
      new Timer(TIMER_DELAY, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            delta++;
            repaint(delta - 10, delta - 10, DELTA_WIDTH + 20, DELTA_WIDTH + 20);
         }
      }).start();
   }

   private BufferedImage createMyImage() {
      BufferedImage myImg = new BufferedImage(DELTA_WIDTH, DELTA_WIDTH,
            BufferedImage.TYPE_INT_ARGB);
      Graphics g = myImg.getGraphics();
      g.setColor(HELLO_COLOR);
      g.drawString("Hello", 12, 12);
      g.setColor(Color.red);
      g.drawLine(10, 10, 30, 30);

      g.dispose();
      return myImg;
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, delta, delta, this);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Game2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Game2());
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
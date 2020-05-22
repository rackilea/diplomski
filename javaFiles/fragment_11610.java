import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Starter {
   JButton b     = new JButton("Game");
   JFrame  frame = new JFrame();

   Starter() {

      frame.setSize(200, 200);
      frame.add(b);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      b.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            TryGraph gg = new TryGraph();
         }
      });
      frame.setVisible(true);

   }
   public static void main(String[] args) {
      Starter g = new Starter();

   }
}

class TryGraph {
   static int w = 640, h = 480;

   TryGraph() {
      JFrame mF = new JFrame();
      GPan pan = new GPan();

      mF.setLocationRelativeTo(null);
      mF.setResizable(false);
      mF.setSize(w, h);

      mF.add(pan);

      mF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      mF.setVisible(true);

      pan.playGame();
   }

}

class GPan extends JPanel {

   private boolean       running;
   private BufferedImage image;
   private Graphics2D    g;
   int                   x, y;

   public GPan() {
      x = TryGraph.w;
      y = TryGraph.h;
      init();
   }

   public void init() {
      running = true;
      image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
      g = (Graphics2D) image.getGraphics();
      g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
   }

   public void playGame() {
      repaint();

   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g.create();

      g2.setColor(new Color(102, 102, 102));
      g2.fillRect(0, 0, x, y);
      g2.setColor(new Color(255, 0, 0));
      g2.fillOval(0, 0, 100, 100);
      // g2.drawImage(image,0,0,x,y,null);

      g2.dispose();
   }
}
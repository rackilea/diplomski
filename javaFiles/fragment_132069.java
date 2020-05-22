import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class Window {

   public Window() {
      JFrame frame = new JFrame("Epic Game");
      frame.setSize(800, 600);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      GamePanel panel = new GamePanel();
      frame.add(panel);

      frame.setVisible(true);

      // !! while (true) {
      // panel.repaint();
      // }
   }

   public static void main(String[] args) {
      new Window();
   }
}

@SuppressWarnings("serial")
class GamePanel extends JPanel {
   int nameSwap = 0;
   Player player;

   public GamePanel() {
      player = Player.getInstance();
      repaint();
      System.out.println("Repaint method called");

      this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "moveLeft");
      this.getActionMap().put("moveLeft", new MoveLR(-1));

      this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "moveRight");
      this.getActionMap().put("moveRight", new MoveLR(1));

      this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("S"), "fire");
      this.getActionMap().put("fire", new Fire());
   }

   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(player.getImg().getImage(), player.getX(), player.getY(), 50,
            50, null);
      // System.out.println("Graphics method called");
   }
}

class Player {
   private int xLoc, yLoc;
   private boolean isFiring;
   private String filename;
   private ImageIcon imageicon;
   // !! private URL imgURL;

   private static Player player;

   public Player(int xl, int yl, boolean fire, String name) {
      BufferedImage img = new BufferedImage(20, 20, BufferedImage.TYPE_INT_ARGB);
      Graphics2D g2 = img.createGraphics();
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
      g2.setColor(Color.red);
      g2.fillOval(2, 2, 16, 16);
      g2.dispose();
      imageicon = new ImageIcon(img);
      xLoc = xl;
      yLoc = yl;
      isFiring = fire;
      filename = name;
      // !! imgURL = getClass().getResource(name);
      // imageicon = new ImageIcon(imgURL);
   }

   public static Player getInstance() {
      if (player == null) {
         player = new Player(0, 0, false, "Dog.jpg");
      }
      return player;
   }

   public void fire() {

   }

   public int getX() {
      return xLoc;
   }

   public int getY() {
      return yLoc;
   }

   public void newX(int x) {
      xLoc = x;
   }

   public ImageIcon getImg() {
      return imageicon;
   }

   public void newImg(ImageIcon ii) {
      imageicon = ii;
   }

   // !! public URL getURL(){
   // return imgURL;
   // }
   // !! public void newURL(String n){
   // imgURL = getClass().getResource(n);
   // }
   public void updateObject() {
      // !! imageicon = new ImageIcon(imgURL);
      System.out.println("update object called");
   }
}

class MoveLR extends AbstractAction {
   private int moveVal;
   Player player;

   public MoveLR(int mv) {
      moveVal = mv;
      player = Player.getInstance();
      System.out.println("New MoveLR object made");
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      // TODO Auto-generated method stub
      player.newX(player.getX() + moveVal);
      ((JPanel) e.getSource()).repaint();
      System.out.println("actionPerformed() called");
   }

}

class Fire extends AbstractAction {
   public Fire() {
      System.out.println("Fire created");
   }

   @Override
   public void actionPerformed(ActionEvent arg0) {
      System.out.println("Fire called");
   }
}
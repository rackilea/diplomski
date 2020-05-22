import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

// public class Player extends JPanel implements ActionListener {
public class Player extends JPanel { // !! avoid having GUI's implement listener interfaces
   private static final int TIME_DELAY = 15; // avoid magic numbers
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   Timer time = new Timer(TIME_DELAY, new TimerListener());
   double x = 0;
   double velX = 2;
   double y = 0;
   double velY = 2;

   public Player() {
      // start timer here!
      time.start();

      setKeyBindings();
   }

   private void setKeyBindings() {
      // get action and input maps
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      // get keystroke
      KeyStroke aKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, 0);

      // bind keystroke with an action
      inputMap.put(aKeyStroke, aKeyStroke.toString());
      actionMap.put(aKeyStroke.toString(), new A_Action());
   }

   @Override
   //!! public void paintComponent(Graphics g) {
   protected void paintComponent(Graphics g) {  // should be protected not public
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
      g2.fill(circle);
   }

   @Override //!! make bigger
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class A_Action extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println("A key pressed");
         x++;
         y++;
         repaint();
      }
   }

   public void actionPerformed(ActionEvent e) {
      // x += velX;
      // y += velY;
      // x = x + velX;
      // y = y + velY;
      repaint();
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO: move x and y
         repaint();
      }
   }

   private static void createAndShowGui() {
      Player mainPanel = new Player();

      JFrame frame = new JFrame("Player");
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
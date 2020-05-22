import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class SimpleAnimationEg extends JPanel {
   private static final int OVAL_WIDTH = 20;
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;
   private int x = 0;
   private int y = 0;

   public SimpleAnimationEg() {
      addKeyBindings();
   }

   private void addKeyBindings() {
      InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
      ActionMap actionMap = getActionMap();

      KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(0, -1));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(0, 1));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(-1, 0));

      keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0);
      inputMap.put(keyStroke, keyStroke.toString());
      actionMap.put(keyStroke.toString(), new MyAction(1, 0));
   }

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.RED);
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2.fillOval(x, y, OVAL_WIDTH, OVAL_WIDTH);
   }

   @Override
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class MyAction extends AbstractAction {
      private int xDirection;
      private int yDirection;

      public MyAction(int xDirection, int yDirection) {
         this.xDirection = xDirection;
         this.yDirection = yDirection;
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         x += xDirection;
         y += yDirection;
         repaint();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SimpleAnimationEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SimpleAnimationEg());
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
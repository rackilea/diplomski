import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.util.EnumMap;
import java.util.Map;
import javax.swing.*;

@SuppressWarnings("serial")
public class MoveCircle extends JPanel { 
   private static final int TIME_DELAY = 15; // avoid magic numbers
   private static final int PREF_W = 600;
   private static final int PREF_H = PREF_W;
   Timer time = new Timer(TIME_DELAY, new TimerListener());

   // key presses and releases will change the boolean values held in this Map
   // When an arrow key is pressed, the direction-corresponding boolean is set true
   // and likewise when the arrow key is released the direction corresponding boolean is false
   private Map<Direction, Boolean> dirMap = new EnumMap<>(Direction.class);
   private double x = 0;
   private double velX = 2;
   private double y = 0;
   private double velY = 2;

   public MoveCircle() {
      setKeyBindings();
      time.start();      
   }

   private void setKeyBindings() {
      int condition = WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      // iterate through all the Direction enums
      for (Direction direction : Direction.values()) {
         // set all values to false
         dirMap.put(direction, false);

         // create two key strokes, one for pressed and one for released
         int keyValue = direction.getKeyValue();
         KeyStroke pressedKey = KeyStroke.getKeyStroke(keyValue, 0, false);
         KeyStroke releasedKey = KeyStroke.getKeyStroke(keyValue, 0, true);

         // create two Actions, one for pressed, one for released
         Action pressedAction = new KeyAction(direction, true);
         Action releasedAction = new KeyAction(direction, false);

         // add keystroke to inputMap and use keystroke's toString as binding link
         inputMap.put(pressedKey, pressedKey.toString());
         inputMap.put(releasedKey, releasedKey.toString());

         // link binding links to our actions
         actionMap.put(pressedKey.toString(), pressedAction);
         actionMap.put(releasedKey.toString(), releasedAction);
      }
   }

   @Override
   protected void paintComponent(Graphics g) {  
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      // draw smooth circles
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      Ellipse2D circle = new Ellipse2D.Double(x, y, 40, 40);
      g2.fill(circle);
   }

   @Override 
   public Dimension getPreferredSize() {
      if (isPreferredSizeSet()) {
         return super.getPreferredSize();
      }
      return new Dimension(PREF_W, PREF_H);
   }

   private class KeyAction extends AbstractAction {
      private Direction direction;
      private boolean pressed;

      public KeyAction(Direction direction, boolean pressed) {
         this.direction = direction;
         this.pressed = pressed;               
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         dirMap.put(direction, pressed); // key press simply changes the map, that's it.
      }
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // if JPanel no longer displayed, stop the Timer
         if (!MoveCircle.this.isDisplayable()) {
            ((Timer) e.getSource()).stop();
         }
         // here's the key: iterate through the Direction enum
         for (Direction direction : Direction.values()) {
            // get corresponding boolean from dirMap
            // and if true, change location of x and y
            if (dirMap.get(direction)) {
               x += velX * direction.getDeltaX();
               y += velY * direction.getDeltaY();
            }
         }
         repaint();
      }
   }

   private static void createAndShowGui() {
      MoveCircle mainPanel = new MoveCircle();

      JFrame frame = new JFrame("Move Circle");
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

enum Direction {
   UP("Up", KeyEvent.VK_UP, 0, -1),
   DOWN("Down", KeyEvent.VK_DOWN, 0, 1),
   LEFT("Left", KeyEvent.VK_LEFT, -1, 0),
   RIGHT("Right", KeyEvent.VK_RIGHT, 1, 0);

   private String text; 
   private int keyValue; // KeyEvent.VK_?
   private int deltaX; 
   private int deltaY;

   Direction(String text, int keyValue, int deltaX, int deltaY) {
      this.text = text;
      this.keyValue = keyValue;
      this.deltaX = deltaX;
      this.deltaY = deltaY;
   }

   public String getText() {
      return text;
   }

   public int getKeyValue() {
      return keyValue;
   }

   @Override
   public String toString() {
      return text;
   }

   public int getDeltaX() {
      return deltaX;
   }

   public int getDeltaY() {
      return deltaY;
   }

}
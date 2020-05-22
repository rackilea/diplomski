import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EnumMap;

import javax.swing.*;

public class NewArrowTest extends JPanel {
   private static final String PRESSED = "pressed";
   private static final String RELEASED = "released";
   private static final int TIMER_DELAY = 20;
   private EnumMap<Key, Boolean> keyMap = new EnumMap<NewArrowTest.Key, Boolean>(Key.class);

   public NewArrowTest() {
      keyMap.put(Key.W, false);
      keyMap.put(Key.S, false);
      keyMap.put(Key.UP, false);
      keyMap.put(Key.DOWN, false);

      // set up key binding
      ActionMap actionMap = getActionMap();
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);

      for (Key key : Key.values()) {
         KeyStroke pressedKeyStroke = KeyStroke.getKeyStroke(key.getKeyCode(), 0, false);
         KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(key.getKeyCode(), 0, true);

         inputMap.put(pressedKeyStroke, key.getText() + PRESSED);
         inputMap.put(releasedKeyStroke, key.getText() + RELEASED);
         actionMap.put(key.getText() + PRESSED, new MyArrowBinding(key, false));
         actionMap.put(key.getText() + RELEASED, new MyArrowBinding(key, true));
      }

      // start polling timer or game loop
      new Timer(TIMER_DELAY, new TimerListener()).start();
   }

   private static void createAndShowGui() {
      NewArrowTest mainPanel = new NewArrowTest();

      JFrame frame = new JFrame("NewArrowTest");
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

   private class TimerListener implements ActionListener {
      public void actionPerformed(java.awt.event.ActionEvent e) {
         for (Key key : keyMap.keySet()) {
            System.out.printf("%6s %b%n", key, keyMap.get(key));
            // here we'd move things based on which key is true
         }
         System.out.println();

      };
   }

   private class MyArrowBinding extends AbstractAction {
      private Key key;
      private boolean released;

      public MyArrowBinding(Key key, boolean released) {
         this.key = key;
         this.released = released;
      }

      @Override
      public void actionPerformed(ActionEvent aEvt) {
         keyMap.put(key, !released);
      }
   }

   enum Direction {
      UP("Up"), DOWN("Down"), NEUTRAL("Neutral");
      private String text;

      private Direction(String text) {
         this.text = text;
      }
      public String getText() {
         return text;
      }
   }

   enum Key {
      W("W", Direction.UP, KeyEvent.VK_W), S("S", Direction.DOWN, KeyEvent.VK_S), 
      UP("Up", Direction.UP, KeyEvent.VK_UP), DOWN("Down", Direction.DOWN, KeyEvent.VK_DOWN);

      private String text;
      private Direction direction;
      private int keyCode;

      private Key(String text, Direction direction, int keyCode) {
         this.text = text;
         this.direction = direction;
         this.keyCode = keyCode;
      }

      public String getText() {
         return text;
      }

      public Direction getDirection() {
         return direction;
      }

      public int getKeyCode() {
         return keyCode;
      }

   }
}
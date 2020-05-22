import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class ArrowTest extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   public ArrowTest() {
      ActionMap actionMap = getActionMap();
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);

      for (Direction direction : Direction.values()) {
         inputMap.put(direction.getKeyStroke(), direction.getText());
         actionMap.put(direction.getText(), new MyArrowBinding(direction.getText()));
      }
   }

   private class MyArrowBinding extends AbstractAction {
      public MyArrowBinding(String text) {
         super(text);
         putValue(ACTION_COMMAND_KEY, text);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String actionCommand = e.getActionCommand();
         System.out.println("Key Binding: " + actionCommand);
      }
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      ArrowTest mainPanel = new ArrowTest();

      JFrame frame = new JFrame("ArrowTest");
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

enum Direction {
   UP("Up", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0)),
   DOWN("Down", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0)),
   LEFT("Left", KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0)),
   RIGHT("Right", KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0));

   Direction(String text, KeyStroke keyStroke) {
      this.text = text;
      this.keyStroke = keyStroke;
   }
   private String text;
   private KeyStroke keyStroke;

   public String getText() {
      return text;
   }

   public KeyStroke getKeyStroke() {
      return keyStroke;
   }

   @Override
   public String toString() {
      return text;
   }
}
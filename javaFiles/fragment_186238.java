import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestKeyBindings extends JPanel {

   public TestKeyBindings() {
      add(new JButton("Foo")); // something to draw off focus
      setKeyBindings();
   }

   private void setKeyBindings() {
      ActionMap actionMap = getActionMap();
      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition );

      String vkLeft = "VK_LEFT";
      String vkRight = "VK_RIGHT";
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), vkLeft);
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), vkRight);

      actionMap.put(vkLeft, new KeyAction(vkLeft));
      actionMap.put(vkRight, new KeyAction(vkRight));

   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(300, 200);
   }

   private class KeyAction extends AbstractAction {
      public KeyAction(String actionCommand) {
         putValue(ACTION_COMMAND_KEY, actionCommand);
      }

      @Override
      public void actionPerformed(ActionEvent actionEvt) {
         System.out.println(actionEvt.getActionCommand() + " pressed");
      }
   }

   private static void createAndShowGui() {
      TestKeyBindings mainPanel = new TestKeyBindings();

      JFrame frame = new JFrame("TestKeyListener");
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
import java.awt.event.*;
import javax.swing.*;

public class OverrideTab {
   private static void createAndShowGui() {
      JPanel mainPanel = new JPanel();
      final JTextField jTextField1 = new JTextField("This is the text", 20);

      mainPanel.add(new JButton("Here just to get focus"));
      mainPanel.add(jTextField1);

      // just to move the caret to position 0 so we can see the key
      // bindings code in action          
      jTextField1.addFocusListener(new FocusAdapter() {
         @Override
         public void focusGained(FocusEvent e) {
            jTextField1.setCaretPosition(0);
         }
      });

      // turn tab key as focus traversal off for the component
      jTextField1.setFocusTraversalKeysEnabled(false);

      // set the key bindings
      int condition = JComponent.WHEN_FOCUSED;
      InputMap inputMap = jTextField1.getInputMap(condition);
      ActionMap actionMap = jTextField1.getActionMap();
      String tab = "tab";
      inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, 0), tab);
      actionMap.put(tab, new AbstractAction() {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            jTextField1.setCaretPosition(jTextField1.getText().length());
            System.out.println("here");
         }
      });



      JFrame frame = new JFrame("OverrideTab");
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
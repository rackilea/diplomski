import java.awt.Component;
import java.awt.GridLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class BindingExample extends JPanel {
   private static final int ROWS = 10;
   private static final int COLS = 8;
   JLabel[][] labels = new JLabel[ROWS][COLS];

   public BindingExample() {
      setLayout(new GridLayout(ROWS, COLS));
      for (int r = 0; r < labels.length; r++) {
         for (int c = 0; c < labels[r].length; c++) {
            String labelText = String.format("[%d,  %d]", r, c);
            labels[r][c] = new JLabel(labelText, SwingConstants.CENTER);
            int eb = 4;
            labels[r][c].setBorder(BorderFactory.createEmptyBorder(eb, eb, eb, eb));
            add(labels[r][c]);
         }
      }

      int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
      InputMap inputMap = getInputMap(condition);
      ActionMap actionMap = getActionMap();

      KeyStroke delKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0);
      String delete = "delete";

      inputMap.put(delKeyStroke, delete);
      actionMap.put(delete, new DeleteAction());
   }

   private class DeleteAction extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent evt) {
         PointerInfo pInfo = MouseInfo.getPointerInfo();
         Point ptOnScrn = pInfo.getLocation();
         int xPanel = getLocationOnScreen().x;
         int yPanel = getLocationOnScreen().y;
         int x = ptOnScrn.x - xPanel;
         int y = ptOnScrn.y - yPanel;

         Component component = getComponentAt(x, y);
         if (component != null) {
            JLabel selectedLabel = (JLabel) component;
            System.out.println("Selected Label: " + selectedLabel.getText());
         }
      }
   }

   private static void createAndShowGui() {
      BindingExample mainPanel = new BindingExample();

      JFrame frame = new JFrame("Key Bindings Example");
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
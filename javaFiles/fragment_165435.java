import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class SSCCE2 extends JPanel {
   private static final int ROW_COUNT = 11;
   private static final int colCount = 3;
   private static final Font NORMAL_FONT = new Font("Serif", Font.PLAIN, 18);
   private static final Font SELECTED_FONT = NORMAL_FONT.deriveFont(Font.BOLD);

   private JTextField[][] fields = new JTextField[ROW_COUNT][ROW_COUNT];

   public SSCCE2() {
      FontAction fontAction = new FontAction();
      int condition = WHEN_FOCUSED;

      setLayout(new GridLayout(ROW_COUNT, ROW_COUNT));
      for (int i = 0; i < fields.length; i++) {
         for (int j = 0; j < fields[i].length; j++) {
            JTextField cell = new JTextField(colCount);
            InputMap inputMap = cell.getInputMap(condition);
            ActionMap actionMap = cell.getActionMap();
            int[] arrowKeyCodes = {KeyEvent.VK_UP, KeyEvent.VK_DOWN, 
                  KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT};
            for (int keyCode : arrowKeyCodes) {
               KeyStroke keyStroke = KeyStroke.getKeyStroke(keyCode, 
                     KeyEvent.SHIFT_DOWN_MASK);
               inputMap.put(keyStroke, keyStroke.toString());
               actionMap.put(keyStroke.toString(), fontAction);
            }
            cell.setFont(NORMAL_FONT);
            cell.setHorizontalAlignment(JTextField.CENTER);
            add(cell);
            fields[i][j] = cell;
         }
      }


   }

   private class FontAction extends AbstractAction {
      @Override
      public void actionPerformed(ActionEvent evt) {
         for (JTextField[] row : fields) {
            for (JTextField textField : row) {
               if (textField.hasFocus()) {
                  textField.setFont(SELECTED_FONT);
               } else {
                  textField.setFont(NORMAL_FONT);
               }
            }
         }
      }
   }

   private static void createAndShowGui() {
      SSCCE2 mainPanel = new SSCCE2();

      JFrame frame = new JFrame("SSCCE2");
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
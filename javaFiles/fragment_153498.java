import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.Component;

public class JListSelectionColorTest extends JFrame {

   private String[] exampleText = {
         "Some example text without any color changes",
         "Some more example text without color changes",
         "Even more plain text!",
         "<html>Uncolored Text! <font color=orange>Now some example Text with color!</font> more Uncolored Text!</html>",
         "<html>Uncolored Text! <font color=green>And some more example text with color! Text, Text, Text!</font> more Uncolored Text!</html>",
         "<html>Uncolored Text! <font color=red>A string with red color, Text Text Text!</font> more Uncolored Text!</html>",
         "<html>Uncolored Text! <font color=blue>And finally a string with blue color, Text Text Text!</font> more Uncolored Text!</html>",
         "<html>Uncolored Text! <font color=purple><selection color=white>Testing if some html can turn the selection color white!</selection></font> more Uncolored Text!</html>" };

   public JListSelectionColorTest() {
      super("JList Selection Color Test");

      try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      } catch (Exception e) {
         e.printStackTrace();
      }
      JList<String> exampleJList = new JList<String>(exampleText);

      exampleJList.setCellRenderer(new MyCellRenderer());
      exampleJList.setSelectionForeground(Color.WHITE); 
      add(exampleJList);

      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String[] args) {
      new JListSelectionColorTest();
   }

   private static class MyCellRenderer extends DefaultListCellRenderer {
      // create a non-greedy regex to capture anything between angle brackets.
      private String regex = "\\<.*?\\>";

      @Override
      public Component getListCellRendererComponent(JList<?> list,
            Object value, int index, boolean isSelected, boolean cellHasFocus) {
         if (value == null) {
            return super.getListCellRendererComponent(list, value, index,
                  isSelected, cellHasFocus);
         }

         // only interested in selected Strings
         if (isSelected) {
            String valueStr = value.toString(); // get the String
            valueStr = valueStr.replaceAll(regex, "");  // extract the HTML
            value = valueStr;  // put back into value Object variable
         }
         return super.getListCellRendererComponent(list, value, index,
               isSelected, cellHasFocus);
      }
   }
}
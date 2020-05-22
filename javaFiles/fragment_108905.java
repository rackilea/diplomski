import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings({ "serial"})
public class ShowWordPanelTest extends JPanel {
   // create a ShowWordPanel field -- this is to help guarantee
   // that the instance displayed is the same as the one I change 
   // the value of the word field
   private ShowWordPanel showWordPanel = new ShowWordPanel();
   private JTextField textField = new JTextField(10);
   private AddWordAction addWordAction = new AddWordAction("Add Word");

   public ShowWordPanelTest() {
      textField.setAction(addWordAction);
      JPanel topPanel = new JPanel();
      topPanel.add(textField);
      topPanel.add(new JButton(addWordAction));

      showWordPanel.setBorder(BorderFactory.createTitledBorder("Show Word Panel"));

      setLayout(new BorderLayout());
      add(showWordPanel, BorderLayout.CENTER);
      add(topPanel, BorderLayout.PAGE_START);
   }

   private class AddWordAction extends AbstractAction {
      public AddWordAction(String name) {
         super(name);
         int mnemonic = (int) name.charAt(0);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         String text = textField.getText(); // get text
         showWordPanel.setWord(text); // pass it into the showWordPanel

         // make easy to change text after button press
         textField.selectAll();
         textField.requestFocusInWindow();
      }
   }

   private static void createAndShowGui() {
      ShowWordPanelTest mainPanel = new ShowWordPanelTest();

      JFrame frame = new JFrame("ShowWordPanelTest");
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
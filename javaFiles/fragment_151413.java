import java.awt.event.ActionEvent;
import javax.swing.*;

public class Foo2 extends JPanel {
   private static final String[] NUMBER_TEXTS = {
      "one", "two", "three", "four", "five"
   };


   public Foo2() {

      for (int i = 0; i < NUMBER_TEXTS.length; i++) {
         String numberString = String.valueOf(i + 1);
         Action numberBtnAction = new NumberBtnAction(numberString, NUMBER_TEXTS[i]);
         JButton btn = new JButton(numberBtnAction);
         Action pressBtnAction = new PressButtonAction(btn);
         InputMap inMap = btn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
         ActionMap actionMap = btn.getActionMap();

         KeyStroke keyStroke = KeyStroke.getKeyStroke(numberString.charAt(0));
         inMap.put(keyStroke, NUMBER_TEXTS[i]);
         //!! actionMap.put(NUMBER_TEXTS[i], numberBtnAction);
         actionMap.put(NUMBER_TEXTS[i], pressBtnAction);

         add(btn);
      }

   }

   private class NumberBtnAction extends AbstractAction {
      public NumberBtnAction(String numberString, String numberText) {
         super(numberString);
         putValue(ACTION_COMMAND_KEY, numberText);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         System.out.println(e.getActionCommand());
      }
   }

   private class PressButtonAction extends AbstractAction {
      private AbstractButton btn;

      public PressButtonAction(AbstractButton btn) {
         this.btn = btn;
      }


      @Override
      public void actionPerformed(ActionEvent e) {
         btn.doClick();
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Foo2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Foo2());
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
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class RadioEg extends JPanel {
   private static final String[] RADIO_TEXTS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
   private ButtonGroup buttonGroup = new ButtonGroup();

   public RadioEg() {
      JPanel radioPanel = new JPanel(new GridLayout(0, 1));
      for (String radioText : RADIO_TEXTS) {
         JRadioButton radioButton = new JRadioButton(radioText);
         radioButton.setActionCommand(radioText); // set this!
         radioPanel.add(radioButton); // add to JPanel
         buttonGroup.add(radioButton); // add to button group
      }

      JPanel southPanel = new JPanel();
      southPanel.add(new JButton(new AbstractAction("GetSelection") {

         @Override
         public void actionPerformed(ActionEvent e) {
            ButtonModel buttonModel = buttonGroup.getSelection();
            if (buttonModel != null) {
               String actionCommand = buttonModel.getActionCommand();
               System.out.println("Selected Button: " + actionCommand);
            }
         }
      }));

      setLayout(new BorderLayout());
      add(radioPanel, BorderLayout.CENTER);
      add(southPanel, BorderLayout.PAGE_END);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("RadioEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new RadioEg());
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
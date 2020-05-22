import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class RadioButtonEg extends JPanel {
   public static final String[] RADIO_TEXTS = {"Mon", "Tues", "Wed", "Thurs", "Fri"};

   // *** again declare this in the class.
   private ButtonGroup buttonGroup = new ButtonGroup();
   private JTextField textfield = new JTextField(20);

   public RadioButtonEg() {
      textfield.setFocusable(false);
      JPanel radioButtonPanel = new JPanel(new GridLayout(0, 1));
      for (String radioText : RADIO_TEXTS) {
         JRadioButton radioButton = new JRadioButton(radioText);
         radioButton.setActionCommand(radioText); // **** don't forget this
         buttonGroup.add(radioButton);
         radioButtonPanel.add(radioButton);
      }

      JPanel bottomPanel = new JPanel();
      bottomPanel.add(new JButton(new ButtonAction("Press Me", KeyEvent.VK_P)));

      setLayout(new BorderLayout());
      add(radioButtonPanel, BorderLayout.CENTER);
      add(bottomPanel, BorderLayout.PAGE_END);
      add(textfield, BorderLayout.PAGE_START);
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      @Override
      public void actionPerformed(ActionEvent e) {
         ButtonModel model = buttonGroup.getSelection();
         if (model == null) {
            textfield.setText("No radio button has been selected");
         } else {
            textfield.setText("Selection: " + model.getActionCommand());
         }

      }
   }

   private static void createAndShowGui() {
      RadioButtonEg mainPanel = new RadioButtonEg();

      JFrame frame = new JFrame("RadioButtonEg");
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
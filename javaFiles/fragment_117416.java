import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class CheckBoxList extends JPanel {
   private static final int CHECK_BOX_COUNT = 12; // number of JCheckBoxes
   private List<JCheckBox> checkBoxList = new ArrayList<>(); // list of JCheckBoxes
   private DefaultComboBoxModel<Integer> cModel = new DefaultComboBoxModel<>(); // combo box model
   private JComboBox<Integer> comboBox = new JComboBox<>(cModel); 

   public CheckBoxList() {
      // create JPanel to hold JCheckBoxes
      JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1, 0, 5));
      // create JCheckBoxes and add to both the above JPanel and the checkBoxList 
      for (int i = 0; i < CHECK_BOX_COUNT; i++) {
         String text = "CheckBox " + i;
         JCheckBox checkBox = new JCheckBox(text);
         checkBox.setEnabled(false);  // disabled by default
         checkBoxPanel.add(checkBox);
         checkBoxList.add(checkBox);
      }

      // fill our combo box's model. For this example, I'm just going to use
      // Integers, and then enable only the JCheckBoxes that are multiples of the selected int
      for (int i = 0; i < 5; i++) {
         cModel.addElement(i + 1);
      }

      comboBox.setSelectedIndex(-1); // set combo at empty
      comboBox.addActionListener(new ComboListener()); // add ActionListner

      // JPanel to hold the JComboBox
      JPanel centerPanel = new JPanel(new GridBagLayout());
      centerPanel.add(comboBox);
      int gap = 35;
      centerPanel.setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));

      // add all to the main JPanel (this)
      gap = 5;
      setBorder(BorderFactory.createEmptyBorder(gap, gap, gap, gap));
      setLayout(new BorderLayout());
      add(centerPanel, BorderLayout.CENTER);
      add(checkBoxPanel, BorderLayout.LINE_END);
   }

   private class ComboListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
         // get combo's selection
         int selection = (Integer) comboBox.getSelectedItem();

         // use the information to enable/disable JCheckBoxes
         for (int i = 0; i < checkBoxList.size(); i++) {
            if (i % selection == 0) {
               checkBoxList.get(i).setEnabled(true);
            } else {
               checkBoxList.get(i).setEnabled(false);
            }
         }
      }
   }

   // create and display GUI
   private static void createAndShowGui() {
      CheckBoxList mainPanel = new CheckBoxList();

      JFrame frame = new JFrame("CheckBoxList");
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
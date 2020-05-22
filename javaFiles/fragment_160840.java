import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UniqueRow extends JPanel {
   public static final String[] COLS = {"Col 1", "Col 2"};
   private DefaultTableModel model = new DefaultTableModel(COLS, 0);
   private JTable table = new JTable(model);
   private JTextField textField1 = new JTextField(10);
   private JTextField textField2 = new JTextField(10);

   public UniqueRow() {
      add(new JScrollPane(table));
      add(textField1);
      add(textField2);
      ButtonAction action = new ButtonAction("Add Data");
      textField1.addActionListener(action);
      textField2.addActionListener(action);
      add(new JButton(action));
   }

   private class ButtonAction extends AbstractAction {
      public ButtonAction(String name) {
         super(name);
      }

      @Override
      public void actionPerformed(ActionEvent e) {

         // get text from JTextField
         String text1 = textField1.getText();
         String text2 = textField2.getText();

         // create a data row with it. Can use Vector if desired
         Object[] row = {text1, text2};

         // and add row to JTable
         model.addRow(row);
      }
   }

   private static void createAndShowGui() {
      UniqueRow mainPanel = new UniqueRow();

      JFrame frame = new JFrame("UniqueRow");
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
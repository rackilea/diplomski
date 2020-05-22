import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Test extends JPanel {
   static String var = "One";
   Object rowData[][] = { { var, "Two", "Three" }, { "Four", "Five", "Six" } };
   Object columnNames[] = { "Column One", "Column Two", "Column Three" };
   JTable table;

   DefaultTableModel tableModel;
   JButton button = new JButton("Refresh");

   public Test() {
      tableModel = new DefaultTableModel(rowData, columnNames);
      table = new JTable(tableModel);
      add(table);
      button.addActionListener(new Action());
      add(button);
   }

   private class Action implements ActionListener {

      @Override
      public void actionPerformed(ActionEvent e) {
         String var2 = "ONE";
         System.out.println(var2);
         // String[] data = { "ciao" };
         // tableModel.fireTableStructureChanged();

         tableModel.setValueAt(var2, 0, 0);
      }
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("Test");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new Test());
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
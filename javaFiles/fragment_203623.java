import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TableEg {
   private static final int ROW_HEIGHT = 40;
   private static final String[] TABLE_COLUMNS = {"Foo", "Bar"};

   private static void createAndShowGui() {
      final DefaultTableModel tableModel = new DefaultTableModel(TABLE_COLUMNS, 2);
      JTable table = new JTable(tableModel );
      table.setRowHeight(ROW_HEIGHT);
      JScrollPane scrollpane = new JScrollPane(table);

      JButton addRowBtn = new JButton(new AbstractAction("Add Row") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            tableModel.addRow(new String[]{"", ""});
         }
      });
      JPanel btnPanel = new JPanel();
      btnPanel.add(addRowBtn);

      JFrame frame = new JFrame("TableEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(scrollpane, BorderLayout.CENTER);
      frame.getContentPane().add(btnPanel, BorderLayout.PAGE_END);
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
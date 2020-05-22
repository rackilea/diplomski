import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Foo2b extends JPanel {
   private static final String[] COLUMNS = { "Column One", "Column Two",
         "Column Three", "Column Four", "Column Five" };
   private static final int ROW_COUNT = 30;
   private DefaultTableModel tableModel = new DefaultTableModel(COLUMNS, ROW_COUNT);
   private JTable table = new JTable(tableModel);

   public Foo2b() {
      table.setFillsViewportHeight(true);

      setLayout(new BorderLayout());
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

      add(scrollPane, BorderLayout.CENTER);
   }

   private static void createAndShowGui() {
      Foo2b mainPanel = new Foo2b();

      JFrame frame = new JFrame("Foo2b");
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
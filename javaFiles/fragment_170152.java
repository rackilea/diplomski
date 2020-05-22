import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class TableTest2 {
  public JComponent makeUI() {
    String[] columnNames = {"Layer", "Enabled", "Read Only"};
    Object[][] data = {
      {"Bird", true, false}, {"Cat",  true, false},
      {"Dog",  true, false}, {"Fish", true, false}, {"Pig",  true, false}
    };
    TableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
      }
      @Override public boolean isCellEditable(int row, int col) {
        return col != 0;
      }
    };
    JTable table = new JTable(model) {
      @Override public void changeSelection(
          int rowIndex, int columnIndex, boolean toggle, boolean extend) {
        if (convertColumnIndexToModel(columnIndex) != 0) {
          return;
        }
        super.changeSelection(rowIndex, columnIndex, toggle, extend);
      }
    };
    table.setAutoCreateRowSorter(true);
    table.setCellSelectionEnabled(true);
    table.getColumnModel().setSelectionModel(new DefaultListSelectionModel() {
      @Override public boolean isSelectedIndex(int index) {
        return table.convertColumnIndexToModel(index) == 0;
      }
    });
    return new JScrollPane(table);
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TableTest2().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}
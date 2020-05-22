import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import javax.swing.table.*;

public class TableHeaderIconTest {
  //private final URL url = getClass().getResource("a.png");
  public JComponent makeUI() {
    String[] columnNames = {"Column1", "Column2", "Column3"};
    JTable table = new JTable(new DefaultTableModel(columnNames, 3));
    TableColumnModel m = table.getColumnModel();
    for (int i = 0; i < m.getColumnCount(); i++) {
      TableColumn column = m.getColumn(i);
      column.setHeaderRenderer(new FilterIconHeaderRenderer4());
      //column.setHeaderValue(
      //  String.format("<html><table><td><img src='%s'/><td>%s", url, columnNames[i]));
    }
    table.setAutoCreateRowSorter(true);

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    return p;
  }
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override public void run() {
        createAndShowGUI();
      }
    });
  }
  public static void createAndShowGUI() {
    try {
      for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(laf.getName())) {
          UIManager.setLookAndFeel(laf.getClassName());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new TableHeaderIconTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}

class FilterIconHeaderRenderer4 implements TableCellRenderer {
  private final URL url = getClass().getResource("Ok2mc.png");
  @Override public Component getTableCellRendererComponent(
      JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    TableCellRenderer r = table.getTableHeader().getDefaultRenderer();
    String str = Objects.toString(value, "");
    String html = String.format("<html><table><td><img src='%s'/><td>%s", url, str);
    return r.getTableCellRendererComponent(table, html, isSelected, hasFocus, row, column);
  }
}
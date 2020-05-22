import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;

public class ComboBoxCellEditorTogglePopupTest {
  private JComboBox<String> makeComboBox() {
    JComboBox<String> combobox = new JComboBox<>();
    combobox.addItem("Item 1");
    combobox.addItem("Item 2");
    combobox.addItem("Item 3");
    return combobox;
  }
  public JComponent makeUI() {
    String[] columnNames = {"Default", "setEnabled", "String"};
    Object[][] data = {
      {"Item 1", "Item 1", "aaa"}, {"Item 2", "Item 3", "bbb"}
    };
    JTable table = new JTable(new DefaultTableModel(data, columnNames));
    table.setRowHeight(20);

    table.getColumnModel().getColumn(0).setCellEditor(
        new DefaultCellEditor(makeComboBox()));

    final JComboBox<String> combobox = makeComboBox();
    combobox.setEnabled(false);
    combobox.addAncestorListener(new AncestorListener() {
      @Override public void ancestorAdded(AncestorEvent e) {
        System.out.println("ancestorAdded");
        EventQueue.invokeLater(new Runnable() {
          @Override public void run() {
            combobox.setEnabled(true);
          }
        });
      }
      @Override public void ancestorRemoved(AncestorEvent e) {
        System.out.println("ancestorRemoved");
        combobox.setEnabled(false);
      }
      @Override public void ancestorMoved(AncestorEvent e) {}
    });
    table.getColumnModel().getColumn(1).setCellEditor(
        new DefaultCellEditor(combobox));

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
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.getContentPane().add(new ComboBoxCellEditorTogglePopupTest().makeUI());
    f.setSize(320, 240);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
  }
}
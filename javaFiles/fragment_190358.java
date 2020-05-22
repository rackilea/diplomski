import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.*;

public class DecimalPlacesInTable2 extends JFrame {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      DecimalPlacesInTable2 frame = new DecimalPlacesInTable2();
      frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
    });
  }

  public DecimalPlacesInTable2() {
    Object[] columnNames = { "A", "B", "C" };
    Object[][] data = {
      {850.503,   850.545,  80.54553},
      {50.52503,  36.4554,  50.41453},
      {80.544653, 8.3,      80.4553},
      {50.1553,   246.0943, 50.455}
    };
    //JTable table = new JTable(data, columnNames);
    TableModel model = new DefaultTableModel(data, columnNames) {
      @Override public Class<?> getColumnClass(int column) {
        return Double.class;
      }
    };
    JTable table = new JTable(model);

    // Tell the table what to use to render our column of doubles
    for (int i = 0; i < 3; i++) {
      table.getColumnModel().getColumn(i).setCellRenderer(new DecimalFormatRenderer());
      //getContentPane().add(new JScrollPane(table));
    }
    getContentPane().add(new JScrollPane(table));
  }

  // Custom Renderer class
  static class DecimalFormatRenderer extends DefaultTableCellRenderer {
    private final DecimalFormat formatter = new DecimalFormat("#.00");
    @Override public Component getTableCellRendererComponent(
        JTable table, Object value, boolean isSelected, boolean hasFocus,
        int row, int column) {
      JLabel cell = (JLabel) super.getTableCellRendererComponent(
          table, value, isSelected, hasFocus, row, column);

      //set Alignment
      cell.setHorizontalAlignment(SwingConstants.CENTER);

      //set selection colors
      if (isSelected) {
        cell.setBackground(new Color(0x3399FF));
        cell.setForeground(new Color(0x000000)); // AM
      } else {
        // set color
        cell.setBackground(new Color(0xC8C8C8));
        cell.setForeground(new Color(0xFFFFFF));
      }

//       // set decimals
//       if (value instanceof Double) {
//         cell.setText(formatter.format(value));
//       }

      return cell;
    }
    @Override public void setValue(Object value) {
        setText(value instanceof Double ? formatter.format(value) : "");
    }
  }
}
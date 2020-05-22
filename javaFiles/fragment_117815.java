import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class TableGridLineTest {
  public JComponent makeUI() {
    JTable table = new JTable(5, 3);
    table.setAutoCreateRowSorter(true);
    table.setFillsViewportHeight(true);
    table.setShowVerticalLines(false);
    //table.setShowHorizontalLines(false);
    table.setIntercellSpacing(new Dimension(0, 1));
    table.setBorder(BorderFactory.createEmptyBorder());
    table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());

    table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
      private final CellBorder border = new CellBorder(2, 2, 2, 2);
      @Override public Component getTableCellRendererComponent(
          JTable table, Object value, boolean isSelected, boolean hasFocus,
          int row, int column) {
        JLabel c = (JLabel) super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
        border.isStartCell = column == 0;
        c.setBorder(border);
        c.setBackground(Color.ORANGE);
        return c;
      }
    });

    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
      private final CellBorder border = new CellBorder(2, 2, 2, 2);
      @Override public Component getTableCellRendererComponent(
          JTable table, Object value, boolean isSelected, boolean hasFocus,
          int row, int column) {
        JComponent c = (JComponent) super.getTableCellRendererComponent(
            table, value, isSelected, hasFocus, row, column);
        border.isStartCell = column == 0;
        c.setBorder(border);
        return c;
      }
    });

    JScrollPane scroll = new JScrollPane(table);
    scroll.setBorder(BorderFactory.createLineBorder(Color.ORANGE));

    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 20));
    p.add(scroll);
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new TableGridLineTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}

class CellBorder extends EmptyBorder {
  private final Color gridColor = UIManager.getColor("Table.gridColor");
  public boolean isStartCell = false;
  protected CellBorder(int top, int left, int bottom, int right) {
    super(top, left, bottom, right);
  }
  @Override public boolean isBorderOpaque() {
    return true;
  }
  @Override public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.translate(x, y);
    g2.setPaint(gridColor);
    if (!isStartCell) {
      g2.drawLine(0, 0, 0, h - 1); // Left line
    }
    g2.dispose();
  }
}
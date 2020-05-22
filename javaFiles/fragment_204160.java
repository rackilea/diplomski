import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTablePopupMenuTest {
  public JComponent makeUI() {
    JTable table = new JTable(new DefaultTableModel(5, 3));
    table.setFillsViewportHeight(true);
    JPopupMenu popupMenu = new JPopupMenu() {
      @Override
      public void show(Component invoker, int x, int y) {
        //int rowAtPoint = table.rowAtPoint(
        //    SwingUtilities.convertPoint(this, new Point(x, y), table));
        //FilesManager.this.generateTablePopupMenu(rowAtPoint);
        int rowAtPoint = table.rowAtPoint(new Point(x, y));
        System.out.println(rowAtPoint);
        super.show(invoker, x, y);
      }
    };
    table.setComponentPopupMenu(popupMenu);

    JPanel p = new JPanel(new BorderLayout());
    p.add(new JScrollPane(table));
    return p;
  }
  public static void main(String... args) {
    EventQueue.invokeLater(() -> {
      JFrame f = new JFrame();
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      f.getContentPane().add(new JTablePopupMenuTest().makeUI());
      f.setSize(320, 240);
      f.setLocationRelativeTo(null);
      f.setVisible(true);
    });
  }
}
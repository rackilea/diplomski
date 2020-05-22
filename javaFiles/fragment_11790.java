import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class TableDataChange
{
  public static void main(String[] args)
  {
    DefaultTableModel tableModel = new DefaultTableModel(
        new Object[][] {{"", "", ""}},
        new Object[] {"ID", "Column 2", "Column 3"});

    tableModel.addTableModelListener(new TableModelListener()
    {
      @Override
      public void tableChanged(TableModelEvent e)
      {
        String id = (String) tableModel.getValueAt(e.getFirstRow(), 0);
        if (id != null)
        {
          Vector row = Database.loadRowForId(id);
          tableModel.getDataVector().set(e.getFirstRow(), row);
          tableModel.addRow(new Vector());
        }
      }
    });

    JTable table = new JTable(tableModel);

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setBounds(300, 200, 400, 300);
    f.setVisible(true);
  }
}

// Mock database
class Database
{
  static Vector loadRowForId(String id)
  {
    Vector row = new Vector();
    if (id.equals("111"))
    {
      row.add("111");
      row.add("aaa");
      row.add("bbb");
    }
    else if (id.equals("222"))
    {
      row.add("222");
      row.add("ppp");
      row.add("qqq");
    }
    return row;
  }
}
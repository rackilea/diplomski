import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel
{

  private String[] columnNames =
  {
    "First Column",
    "Custom JPanel",
  };
  private Object[][] data =
  {
    {"Foo", new CustomJPanel()},
    {"Bar", new CustomJPanel()}
  };

  public int getColumnCount()
  {
    return columnNames.length;
  }

  public int getRowCount()
  {
    return data.length;
  }

  public String getColumnName(int col)
  {
    return columnNames[col];
  }

  public Object getValueAt(int row, int col)
  {
    return data[row][col];
  }

  public Class getColumnClass(int c)
  {
    return getValueAt(0, c).getClass();
  }

  public boolean isCellEditable(int row, int col)
  {
    return col >= 1;
  }

  public void setValueAt(Object value, int row, int col)
  {
    data[row][col] = value;
    fireTableCellUpdated(row, col);
  }

}
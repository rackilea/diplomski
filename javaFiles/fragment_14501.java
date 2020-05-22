import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class CustomJPanelEditor extends AbstractCellEditor implements TableCellEditor
{
  CustomJPanel customJPanel;

  public CustomJPanelEditor()
  {
    customJPanel = new CustomJPanel();
  }

  @Override
  public java.awt.Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
  {
    customJPanel = (CustomJPanel) value;
    return customJPanel;
  }

  @Override
  public Object getCellEditorValue()
  {
    return customJPanel;
  }
}
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class CustomJPanelRenderer implements TableCellRenderer
  {

    CustomJPanel rendererJPanel;

  public CustomJPanelRenderer()
  {
    rendererJPanel = new CustomJPanel();
  }


    @Override
    public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) 
    {
      rendererJPanel = (CustomJPanel) value;
      return rendererJPanel;
    }
  }
<!-- language: lang-java -->
getCellRenderer(int row, int column)

public class MyTable extends JTable
{
   @Override
   public TableCellRenderer getCellRenderer(int row, int column) 
   {
      return new TableCellRenderer()
      {
          Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, 
                    int row, int column)
          {
              Component cellRenderComponent = this.MyTable.super.getCellRenderer(row, column);
              if (getModel().getValue(row,column).toString().equalsIgnoreCase("true"))
              {
                  cellRenderComponent.setBackground(Color.green);
              }
              else
              {
                  cellRenderComponent.setBackground(Color.red);
              }

          }
      }
   }

}
class MyLabelProvider extends LabelProvider implements ITableLabelProvider
 {
   @Override
   public String getColumnText(Object element, int columnIndex)
   {
     RowData rowData = (RowData)element;

     return rowData.getColumn(columnIndex);
   }

   @Override
   public Image getColumnImage(Object element, int columnIndex)
   {
     return null;
   }
 }
TableCellRenderer renderer = null;
 if (columnModel.getColumnCount() > 0)
   renderer = columnModel.getColumn(column).getCellRenderer();
 if (renderer == null)
   {
     int mcolumn = convertColumnIndexToModel(column);
     renderer = getDefaultRenderer(dataModel.getColumnClass(mcolumn));
   }
 return renderer;
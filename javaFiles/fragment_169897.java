class TableModel extends DefaultTableModel { 

  public TableModel(Object[] headers) { 
    super(null, headers);
  } 

  public Class getColumnClass(int c) { 
    switch (c) { 
      case 0: return Boolean.class;
      default: return String.class; 
    } 
  } 

  public boolean isCellEditable(int row, int column) { 
    if (column == 0) return true;
    return false;
  } 
}

TableModel tableModel = new TableModel(<headers as String []>);
JTable table = new JTable(tableModel);
....

TableColumnModel columnModel = table.getColumnModel();
// setting the first column to use checkboxes
columnModel.getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
...

int rowCount = tableModel.getRowCount();
for(int i=0; i<rowCount; i++) {
  Boolean selected = (Boolean)tableModel.getValueAt(0, 0);
  if(selected) {
    tableModel.removeRow(0);
  }
}
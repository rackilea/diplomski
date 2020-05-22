class DataModel extends AbstractTableModel
{


    public DataModel(Object yourData){
         //some code here
    }

    @Override
    public int getRowCount() {
        return yourData.rows;
    }

    @Override
    public int getColumnCount() {
        return yourData.colums;
    }

    @Override
    public Class<?> getColumnClass(int col) {
        if (col == myBooleanColumn) {
            return Boolean.class;
        } else {
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) 
    {
        return col >= 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return yourData.get(rowIndex,columnIndex);
    }

    @Override
    public void setValueAt(Object aValue, int row, int col) {           

    yourData.set(aValue,row,col)    

        this.fireTableCellUpdated(row, col);  
    }
}
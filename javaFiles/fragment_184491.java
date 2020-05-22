TableRowSorter<TableModel> sorter =
    new DefaultTableRowSorter<TableModel>(this.getModel()) 
{
    public int convertRowIndexToModel(int index)
    {
        int maxRow = super.getViewRowCount();
        if (index >= maxRow)
            return index;
        return super.convertRowIndexToModel(index);
    }

    public int convertRowIndexToView(int index) 
    {
        int maxRow = super.getModelRowCount();
        if (index > maxRow)
            return index;
        return super.convertRowIndexToView(index);
    }

    public int getViewRowCount() 
    {
        return super.getViewRowCount() + 1;
    }
};

myTable.setRowSorter(sorter);
final int[] ids = new int[]{1, 39, 45, 55, 22};
RowFilter<Object, Object> filter = new RowFilter<Object, Object>() {
  public boolean include(Entry entry) {
    L currentObject = (L) (entry.getValue(0));
    for(int i=0;i<ids.length;i++){
        if(currentObject.getId()==ids[i]){
            return true;
        }
    }
    return false;
  }
};

TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
sorter.setRowFilter(filter);
yourTable.setRowSorter(sorter);
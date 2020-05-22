@Override
public void setRowIndex(int rowIndex) {
    /*
     * The following is in ancestor (LazyDataModel):
     * this.rowIndex = rowIndex == -1 ? rowIndex : (rowIndex % pageSize);
     */
    if (rowIndex == -1 || getPageSize() == 0) {
        super.setRowIndex(-1);
    }
    else
        super.setRowIndex(rowIndex % getPageSize());
}
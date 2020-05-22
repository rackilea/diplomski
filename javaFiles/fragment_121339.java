private DataTable dataTable;

public DataTable getDataTable() {
   return dataTable;
}

public void setDataTable(DataTable dataTable) {
    this.dataTable = dataTable;
}

public void methodToAccessSortOrder() {
   String sortOrder = this.dataTable.getSortOrder();
   // do anything with sortOrder
}
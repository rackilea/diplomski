public ScrollableTable(String[][] aData, String[] aColumnNames) {
    super();

    TableModel model = getTableModel(aData, aColumnNames);
    JTable overviewTable = new JTable(model);
    overviewTable.setGridColor(new Color(240, 240, 240));
    TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
    overviewTable.setRowSorter(sorter);

    this.setViewportView(overviewTable);
}
@Override
protected void done() {
    table.setModel(model);
    table.setFillsViewportHeight(true);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    TableColumn columnA = table.getColumn("#");
    columnA.setMinWidth(10);
    columnA.setMaxWidth(40);
    TableColumn columnB= table.getColumn("Start");
    columnB.setMinWidth(80);
    columnB.setMaxWidth(90);
    TableColumn columnC= table.getColumn("End");
    columnC.setMinWidth(80);
    columnC.setMaxWidth(90);
}
TableCellRenderer tableCellRenderer = table.getCellRenderer(row, col);
Component c = table.prepareRenderer(tableCellRenderer, row, col);

if (c instanceof JTable) {
    innerTable = (JTable) c;

    Point pnt = e.getPoint();
    Rectangle cellRect = table.getCellRect(row, col, false);
    pnt.translate(-cellRect.x, -cellRect.y);

    int rowIndex = innerTable.rowAtPoint(pnt);
    int colIndex = innerTable.columnAtPoint(pnt);
    System.out.println("INNERTABLE:" + rowIndex + "*" + colIndex);
}
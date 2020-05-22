private static int columnAtPoint(Table table, Point pt) {
    int colIndex = -1;

    TableItem fakeRow = new TableItem(table, 0);
    for (int i = 0; i < table.getColumnCount(); i++) {
        Rectangle rec = fakeRow.getBounds(i);
        if ((pt.x > rec.x)  && (pt.x < (rec.x + rec.width))) {
            colIndex = i;
        }
    }
    fakeRow.dispose();
    return colIndex;
}
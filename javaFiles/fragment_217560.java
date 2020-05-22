while (true) {
    // available height of the page
    float available_height = 770;
    // how many rows fit the height?
    while (available_height > 0 && currentRow < totalRows) {
        available_height -= table.getRowHeight(currentRow++);
    }
    // we stop as soon as all the rows are counted
    if (currentRow == totalRows)
        break;
    // we draw part the rows that fit the page and start a new page
    table.writeSelectedRows(currentRowStart, --currentRow, 36, 806, canvas);
    document.newPage();
    currentRowStart = currentRow;
}
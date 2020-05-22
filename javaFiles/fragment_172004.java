Row r = sheet.getRow(9); // 10-1
if (r == null) {
   // First cell in the row, create
   r = sheet.createRow(9);
}

Cell c = r.getCell(3); // 4-1
if (c == null) {
    // New cell
    c = r.createCell(3, Cell.CELL_TYPE_NUMERIC);
}
c.setCellValue(100);
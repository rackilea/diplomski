CellRangeAddress range = CellRangeAddress.valueOf(startCell + ":" + endCell);
for (int row = range.getFirstRow(); row <= range.getLastRow(); ++row) {
    for (int col = range.getFirstColumn(); col <= range.getLastColumn(); ++col) {
         Cell cell = sheet.getRow(row).getCell(col);
         //do something with cell
    }
}
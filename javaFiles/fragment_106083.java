int lastColumn = Math.max(row.getLastCellNum(), MY_MINIMUM_COLUMN_COUNT);

for (int cn = 0; cn < lastColumn; cn++) {
  Cell c = row.getCell(cn, Row.RETURN_BLANK_AS_NULL);
  if (c == null) {
    // The spreadsheet is empty in this cell
  } else {
    // Do something useful with the cell's contents
  }
}
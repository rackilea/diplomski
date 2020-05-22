CellStyle getPreferredCellStyle(Cell cell) {
  // a method to get the preferred cell style for a cell
  // this is either the already applied cell style
  // or if that not present, then the row style (default cell style for this row)
  // or if that not present, then the column style (default cell style for this column)
  CellStyle cellStyle = cell.getCellStyle();
  // if no explicit cell style applied then cellStyle.getIndex() is 0 for XSSF
  // or 15 (0xF = the index to the default ExtendedFormatRecord (0xF)) for HSSF
  if ((cell instanceof XSSFCell && cellStyle.getIndex() == 0) || (cell instanceof HSSFCell && cellStyle.getIndex() == 15)) cellStyle = cell.getRow().getRowStyle();
  if (cellStyle == null) cellStyle = cell.getSheet().getColumnStyle(cell.getColumnIndex());
  if (cellStyle == null) cellStyle = cell.getCellStyle();
  return cellStyle;
 }
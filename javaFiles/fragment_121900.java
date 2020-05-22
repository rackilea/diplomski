// Do this once
DataFormatter formatter = new DataFormatter();

// Once per row
for (Row row : sheet) {
  String exCode = formatter.formatCellValue( row.getCell(2) );
  String prCode = formatter.formatCellValue( row.getCell(3) );

  Cell code = row.createCell(4, Cell.CELL_TYPE_STRING);
  code.setCellValue(exCode + prCode);
}
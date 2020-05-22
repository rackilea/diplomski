CellReference cr = new CellReference("B1");
XSSFRow row = currentActiveSheet.getRow(cr.getRow());
XSSFCell cell = row.getCell(cr.getCol());

cell.setCellValue(value);
cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
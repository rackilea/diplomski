**XSSFCell cell = row.createCell(1);

if (cell == Cell.CELL_TYPE_BLANK){
   cell.setCellType(Cell.CELL_TYPE_STRING);
   cell.setCellValue("Apple");
}
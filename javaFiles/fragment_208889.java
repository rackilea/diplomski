Cell cell = row.getCell(j); 
CellValue cellValue = evaluator.evaluate(cell);
switch (cellValue.getCellType()) {
    case Cell.CELL_TYPE_NUMERIC:
    cellData[i][j] = String.valueOf(cellValue.getNumberValue());
    break;
    case Cell.CELL_TYPE_STRING:
    cellData[i][j] = cell.getStringCellValue();
    break
}
boolean hasDataFlag = true;    
HSSFRow row = sheet.getRow(rowNumber);
hasDataFlag = (row != null);
HSSFCell cell = null;
if (hasDataFlag) cell = row.getCell(cellNumber);
hasDataFlag = (cell != null);
if (hasDataFlag) hasDataFlag = (cell.getCellType() != Cell.CELL_TYPE_BLANK);
if (hasDataFlag) {
    // process the cell here
}
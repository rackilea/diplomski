@Override
public List < String > processSheet(Sheet sheet) {
    ActivityLauncher.logConsoleMsg("Processing sheet " + sheet.getSheetName() + " started");
    List <String> rows = new ArrayList<String>();
    Iterator<Row> rowIterator = sheet.iterator();
    final int startCell = 0;
    while (rowIterator.hasNext()) {
        Row currentRow = rowIterator.next();
        StringBuilder row = new StringBuilder();
        // not sure if you really need this if statement in your Prod code
        if (currentRow.getRowNum() == 0 || currentRow.getRowNum() == 1 || 
                currentRow.getRowNum() == 2 || currentRow.getRowNum() == 3 || 
                currentRow.getRowNum() == 4 || currentRow.getRowNum() == 5 || 
                currentRow.getRowNum() == 6 || currentRow.getRowNum() == 7 || 
                currentRow.getRowNum() == 9 || currentRow.getRowNum() == 10 || 
                currentRow.getRowNum() == 11) {
            continue;
        } 
        if (currentRow.getLastCellNum() < 0 || currentRow.getCell(startCell) == null || "".equals(currentRow.getCell(startCell).getStringValue()) || (currentRow.getCell(startCell).getStringValue() != null && currentRow.getCell(startCell).getStringValue().contains("Total"))) {
            continue;
       }
       for (int i = 0; i < currentRow.getLastCellNum(); i++) {
         else {
            Cell currentCell = currentRow.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            String cellValue = excelManager.evalCell(currentCell);
            if (!cellValue.isEmpty()) {
                row.append(cellValue);
            }

            //adjusting the cell values with the | or BLANK 
            if (currentCell == null || currentCell.getCellType() == Cell.CELL_TYPE_BLANK) {
                row.append("");
            } else {
                row.append(SEPARATOR);
            }
        }
    }
    if (!row.toString().isEmpty()) {
        rows.add(row.toString());
    }
  }
  ActivityLauncher.logConsoleMsg("Processing sheet " + sheet.getSheetName() + " completed");
  return rows;
}
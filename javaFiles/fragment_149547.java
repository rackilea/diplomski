int rowIndex = 0;
int firstCellInRow = 0;
int cellCount = listOfResults.size();
int cellsPerRow = 7;
int rowCount = cellCount / cellsPerRow;

for (int i = 0; i < rowCount; i++) {

    // detect first header cell
    firstCellInRow = i * cellsPerRow;
    if (listOfResults.get(firstCellInRow).equals("S.NO")) {
        // create a new sheet
        sheet = wb.createSheet();
        // reset the row index to 0
        rowIndex = 0;
    }

    // create the row and increment the row index
    row = sheet.createRow(rowIndex++);

    // now add the data to the cells
    for (int j = 0; j < cellsPerRow; j++) {
        cell = row.createCell(j);
        if (firstCellInRow + j < listOfResults.size()) {
            cell.setCellValue(listOfResults.get(firstCellInRow + j));
        }
    }
}
for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
  row = sheet.getRow(rowIndex);
  if (row != null) {
    String cellValueMay = null;
    for (int colIndex = 0; colIndex < colCount; colIndex++) {
      if (colIndex == theColIndexYouWant) {
        cell = row.getCell(colIndex);
        if (cell != null) {
          // Found column and there is value in the cell.
          cellValueMaybeNull = cell.getStringCellValue();
          break;
        }
    }

    // Do something with the cellValueMaybeNull here ...
  }
}
for (int rowNum = excelWSheet.getLastRowNum(); rowNum >= 0; rowNum--) {
    final Row row = excelWSheet.getRow(rowNum);
    if (row != null && row.getCell(colNum) != null) {
        rowIndex = rowNum;
        break;
    }
}
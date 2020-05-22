public int getNumOfMergedRows(String colName, int startingRow) {
    int rowsMerged = 0, col = 0;
    XSSFRow mergedRow = null;
    XSSFCell mergedCell = null;
    try {
        col = getExcelColNum(colName);
        for (int i = startingRow + 1; i < sheet.getPhysicalNumberOfRows(); i++) {
            mergedRow = sheet.getRow(i);
            mergedCell = mergedRow.getCell(col);
            if (mergedCell.getCellTypeEnum() == null || mergedCell.getCellTypeEnum() == CellType.BLANK)
                rowsMerged++;
            else
                break;
        }
        rowsMerged++;
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    logger.info(rowsMerged + " rows are merged in columne" + colName + " for " + scriptName + " script");
    return rowsMerged;
}
HSSFRow row = sheet.getRow(rowNumber);
if (row != null) {
    HSSFCell cell = row.getCell(cellNumber, Row.RETURN_BLANK_AS_NULL);
    if (cell != null) {
        // process cell here
    }
}
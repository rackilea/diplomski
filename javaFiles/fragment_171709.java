for(int rowNumber = 0; rowNumber < sheet.getLastRowNum(); rowNumber++) {
    HSSFRow row = sheet.getRow(rowNumber);

    for(int columnNumber = 0; columnNumber < row.getLastCellNum(); columnNumber++) {
        HSSFCell cell = row.getCell(columnNumber);
        if(cell != null) {
            // do something with the cell
        }
}
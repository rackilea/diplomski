private int getContractYearColumnIndex(){
    final int maxColIndex = 25;
    int colIndex = 0;
    HSSFRow titleRow = yourSheet.getRow(0);
    String value = titleRow.getCell(colIndex).getStringCellValue();

    while(value != "Contract Year" && colIndex < maxColIndex){
        colIndex = colIndex + 1;
        value = titleRow.getCell(colIndex).getStringCellValue();
    }
    return colIndex;
}
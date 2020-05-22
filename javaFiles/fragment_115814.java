private void duplicateInPlace() {
    XSSFSheet firstSheetObj = this.firstWB.getSheet(firstSheetName);
    XSSFSheet targetSheetObj = this.targetWB.createSheet(this.targetSheetName);
    int firstSheetLen = firstSheetObj.getLastRowNum();
    replaceMinusOnes(firstSheetObj,firstSheetObj);
    int targetCursorPosition=0;


    //
    for (int i = 0; i <  rangeStart ; i++) {
        XSSFRow firstRow = firstSheetObj.getRow(i);
        XSSFRow targetRow = targetSheetObj.createRow(targetCursorPosition);
        this.copyRow(firstRow,targetRow);
        targetCursorPosition+=1;

    }//endfor

    for (int i = rangeStart; i <  rangeEnd ; i++) {
        XSSFRow firstRow = firstSheetObj.getRow(i);
        XSSFRow targetRow = targetSheetObj.createRow(targetCursorPosition);
        this.copyRow(firstRow,targetRow);

        XSSFRow targetRow2 = targetSheetObj.createRow(targetCursorPosition+1);
        this.copyRow(firstRow,targetRow2); //this part duplicates
        targetCursorPosition+=2;

    }

    for (int i = rangeEnd; i <  firstSheetLen ; i++) {
        XSSFRow firstRow = firstSheetObj.getRow(i);
        XSSFRow targetRow = targetSheetObj.createRow(targetCursorPosition);
        this.copyRow(firstRow,targetRow);
        targetCursorPosition+=1;
    }
}
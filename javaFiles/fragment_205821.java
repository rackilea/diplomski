public static void removeRow(HSSFSheet sheet, int rowIndex) {
    int lastRowNum=sheet.getLastRowNum();
    if(rowIndex>=0&&rowIndex<lastRowNum){
        sheet.shiftRows(rowIndex+1,lastRowNum, -1);
    }
    if(rowIndex==lastRowNum){
        HSSFRow removingRow=sheet.getRow(rowIndex);
        if(removingRow!=null){
            sheet.removeRow(removingRow);
        }
    }
}
private HSSFRow getRow(HSSFSheet sheet, int rowNum) {
 HSSFRow sheetRow = null;
 sheetRow = sheet.getRow(rowNum);
  if (null == sheetRow) {
    sheetRow = sheet.createRow(rowNum);
 }  
 return sheetRow;
 }
HSSFWorkbook workbook = new XSSFWorkbook(); 

// Cell styles. Note the setLocked(true) method call. 
HSSFCellStyle lockedNumericStyle = workbook.createCellStyle(); 
lockedNumericStyle.setAlignment(XSSFCellStyle.ALIGN_RIGHT); 
lockedNumericStyle.setLocked(true); 

HSSFSheet sheet = workbook.createSheet("Protection Test"); 
HSSFRow row = sheet.createRow(0); 
HSSFCell cell = row.createCell(0); 
cell.setCellValue(100); 
cell.setCellStyle(lockedNumericStyle); 

// This line should cause all locked cells to be protected, 
// the user should not be able to change the cells 
// contents. 
sheet.protectSheet("password"); 

The password makes it possible to remove the protection from the sheet and makes it possible then for the locked cells to be modified.
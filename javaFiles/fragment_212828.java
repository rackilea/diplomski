SXSSFWorkbook workbook = new SXSSFWorkbook(50); 
Sheet sheet = workbook.createSheet("Image Data"); 
....
Cell cell = row.createCell(j);
cell.setCellValue(j);
XSSFCellStyle cs1 = (XSSFCellStyle) workbook.createCellStyle();
cs1.setFillForegroundColor(new XSSFColor(new java.awt.Color(red,green,blue)));          
cs1.setFillPattern(CellStyle.SOLID_FOREGROUND);
cell.setCellStyle(cs1);
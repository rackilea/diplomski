FileOutputStream fileOut = new FileOutputStream("poi-test.xls");
HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet sheet = workbook.createSheet("Readings");
CellStyle style = workbook.createCellStyle();
Font font = workbook.createFont();
font.setFontHeightInPoints((short)11);
font.setFontName(HSSFFont.FONT_ARIAL);
font.setBoldweight(HSSFFont.COLOR_NORMAL);
font.setBold(true);
font.setColor(HSSFColor.DARK_BLUE.index);

style.setFont(font);
//Add these lines     
style.setFillForegroundColor(IndexedColors.AQUA.getIndex());
style.setFillPattern(CellStyle.SOLID_FOREGROUND);

sheet.createFreezePane(0, 1); // Freeze 1st Row   sheet.createFreezePane(int colSplit, int rowSplit, int leftmostColumn, int topRow)


 HSSFRow rowhead = sheet.createRow((short) 0);
 rowhead.setRowStyle(style);
 //Set the cell0 Style        
 HSSFCell cell0 = rowhead.createCell(0);
 cell0.setCellStyle(style);
 cell0.setCellValue("ROW");
 //Set the cell1 Style        
 HSSFCell cell1 = rowhead.createCell(1);
 cell1.setCellStyle(style);
 cell1.setCellValue("NUMBER");

 workbook.write(fileOut);
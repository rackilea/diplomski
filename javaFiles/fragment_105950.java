XSSFCellStyle my_style = (XSSFCellStyle) wb.createCellStyle();
XSSFFont my_font=(XSSFFont) wb.createFont();
my_font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
my_style.setFont(my_font);
XSSFDataFormat df =(XSSFDataFormat) wb.createDataFormat(); 
my_style.setDataFormat(df.getFormat("#,##0"));
Sheet sheet = wb.createSheet("test");
CellStyle cs = wb.createCellStyle();
Font f = wb.createFont();
f.setBoldweight(Font.BOLDWEIGHT_BOLD);
cs.setFont(f);
sheet.setDefaultColumnStyle(1,cs); //set bold for column 1
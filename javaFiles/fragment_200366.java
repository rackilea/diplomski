HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet sheet = workbook.createSheet();

HSSFFont font = workbook.createFont();
font.setColor(HSSFColor.WHITE.index);
HSSFCellStyle style = workbook.createCellStyle();
style.setFont(font);
style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
style.setFillForegroundColor(HSSFColor.RED.index);


List<String> header = Arrays.asList(new String [] {"YEAR", "MONTH", "NAME", "SURNAME"});

HSSFRow rowhead = sheet.createRow((short) 0);
int cellnum = 0;
for (String s : header) {
    HSSFCell cell = rowhead.createCell(cellnum++);
    cell.setCellValue(s);
    cell.setCellStyle(style);
}


FileOutputStream fileOut = new FileOutputStream(filename);
workbook.write(fileOut);
fileOut.close();
workbook.close();
HSSFCellStyle cellStyle = workbook.createCellStyle();
cellStyle.setFillForegroundColor(HSSFColor.LIGHT_ORANGE.index);
cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

for (int i = 0; i < columnNamesFase1.length; i++) {
   HSSFCell cellA1 = row1.createCell((short) i);
   cellA1.setCellValue(columnNamesFase1[columnCount]);
   cellA1.setCellStyle(cellStyle);
   worksheet.autoSizeColumn(columnCount);
   columnCount++;
}
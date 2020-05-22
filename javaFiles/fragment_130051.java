HSSFRow row = sheet.createRow(0);
HSSFCell cell = row.createCell((short) 0);
cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);

SimpleDateFormat datetemp = new SimpleDateFormat("yyyy-MM-dd");
Date cellValue = datetemp.parse("1994-01-01 12:00");
cell.setCellValue(cellValue);

//binds the style you need to the cell.
HSSFCellStyle dateCellStyle = wb.createCellStyle();
short df = wb.createDataFormat().getFormat("dd-mmm");
dateCellStyle.setDataFormat(df);
cell.setCellStyle(dateCellStyle);
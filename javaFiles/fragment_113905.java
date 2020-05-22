HSSFWorkbook wb = new HSSFWorkbook();
  HSSFRow row = wb.createSheet().createRow(0);
  CellStyle cellStyle = wb.createCellStyle();
  cellStyle.setDataFormat(wb.getCreationHelper().createDataFormat().getFormat("HH:mm:ss"));
  HSSFCell cell = row.createCell(1);
  Calendar cal = Calendar.getInstance();
  cal.set(Calendar.YEAR, 1970);
  cal.set(Calendar.MONTH, 0);
  cal.set(Calendar.DATE, 1);
  //you can set the time you need here ...
  cell.setCellValue(cal);
  cell.setCellStyle(cellStyle);
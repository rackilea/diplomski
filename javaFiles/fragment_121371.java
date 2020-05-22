HSSFWorkbook wb = ...;
DataFormat format = wb.createDataFormat();

HSSFCellStyle cellStyle = wb.createCellStyle();
style.setDataFormat(format.getFormat("@")); // or "text"
cell.setCellStyle(cellStyle);
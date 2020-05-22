XSSFDataFormat df = workBook.createDataFormat();
cs.setDataFormat(df.getFormat("d-mmm-yy"));

// Get / Create our cell
XSSFRow row = sheet.createRow(2);
XSSFCell cell = row.createCell(3);

// Set it to be a date
Calendar c = Calendar.getInstance();
c.set(2012,3-1,18); // Don't forget months are 0 based on Calendar
cell.setCellValue( c.getTime() );

// Style it as a date
cell.setCellStyle(cs);
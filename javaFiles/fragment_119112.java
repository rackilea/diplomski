HSSFWorkbook workbook = new HSSFWorkbook();
HSSFSheet realSheet = workbook.createSheet("Sheet xls");
HSSFSheet hidden = workbook.createSheet("hidden");
for (int i = 0, length= countryName.length; i < length; i++) {
   String name = countryName[i];
   HSSFRow row = hidden.createRow(i);
   HSSFCell cell = row.createCell(0);
   cell.setCellValue(name);
 }
 Name namedCell = workbook.createName();
 namedCell.setNameName("hidden");
 namedCell.setRefersToFormula("hidden!$A$1:$A$" + countryName.length);
 DVConstraint constraint = DVConstraint.createFormulaListConstraint("hidden");
 CellRangeAddressList addressList = new CellRangeAddressList(0, 0, 0, 0);
 HSSFDataValidation validation = new HSSFDataValidation(addressList, constraint);
 workbook.setSheetHidden(1, true);
 realSheet.addValidationData(validation);
 FileOutputStream stream = new FileOutputStream("c:\\range.xls");
 workbook.write(stream);
 stream.close();
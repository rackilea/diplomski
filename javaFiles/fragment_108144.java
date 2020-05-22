Workbook wb = new XSSFWorkbook();
Sheet sh = wb.createSheet("Sheet1");
CellStyle left = wb.createCellStyle();
left.setAlignment(CellStyle.ALIGN_LEFT);
CellStyle center = wb.createCellStyle();
center.setAlignment(CellStyle.ALIGN_CENTER);

Row r1 = sh.createRow(1);
Cell c1 = r1.createCell(1);
c1.setCellStyle(left);
c1.setCellValue("Left justified text");
Cell c2 = r1.createCell(2);
c2.setCellStyle(center);
c2.setCellValue(1234);
Cell c3 = r1.createCell(3);
c3.setCellStyle(left);
c3.setCellValue("More Left Justified Text");

FileOutputStream fileOut = new FileOutputStream("CellAlignTest.xlsx");
wb.write(fileOut);
wb.close();
fileOut.close();
// setup code
String sname = "TestSheet", cname = "TestName", cvalue = "TestVal";
Workbook wb = new HSSFWorkbook();
Sheet sheet = wb.createSheet(sname);
sheet.createRow(0).createCell((short) 0).setCellValue(cvalue);

// 1. create named range for a single cell using areareference
Name namedCell = wb.createName();
namedCell.setNameName(cname);
String reference = sname+"!A1:A1"; // area reference
namedCell.setRefersToFormula(reference);
Workbook wb = new XSSFWorkbook(); //or new HSSFWorkbook();
CreationHelper createHelper = wb.getCreationHelper();
Cell cell;
Sheet sheet = wb.createSheet("Hyperlinks");
//URL
cell = sheet.createRow(0).createCell((short)0);
cell.setCellValue("Worksheet Link");
Hyperlink link2 = createHelper.createHyperlink(Hyperlink.LINK_DOCUMENT);
link2.setAddress("'Target Sheet'!A1");
cell.setHyperlink(link2);
cell.setCellStyle(hlink_style);
HSSFWorkbook wb = new HSSFWorkbook();
HSSFSheet sheet = wb.createSheet("test sheet");

HSSFCellStyle currencyStyle = wb.createCellStyle();
HSSFDataFormat dataFormat = wb.createDataFormat();
currencyStyle.setDataFormat(dataFormat.getFormat("$#,##0.00.000"));

HSSFRow row1 = sheet.createRow(2);
row1.setHeight((short) (256*1.5));

// Input in DOLLARS
HSSFCell cell1 = row1.createCell(1);
cell1.setCellStyle(currencyStyle);
cell1.setCellValue(Double.parseDouble("5")); // output $5,00,000

// Input in CENTS
HSSFCell cell2 = row1.createCell(2);
cell2.setCellStyle(currencyStyle);
cell2.setCellValue(Double.parseDouble("499") / 100); // output $4,99,000

// Input in 1/1000 OF A CENT
HSSFCell cell3 = row1.createCell(3);
cell3.setCellStyle(currencyStyle);
cell3.setCellValue(Double.parseDouble("123456789") / 100000); // output $1 234,56,789

try {
    FileOutputStream out = new FileOutputStream("currency_data_format.xls");
    wb.write(out);
    out.close();
} catch (IOException e) {
    System.out.println(e.getMessage());
}
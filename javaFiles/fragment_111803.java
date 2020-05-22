Workbook workbook = new HSSFWorkbook();
Sheet sheet = workbook.createSheet("sheet title");
int rowIndex = 0;

for (Item item : items) {
    Row row = sheet.createRow(rowIndex++);
    int columnIndex = 0;

    row.createCell(columnIndex++).setCellValue(item.getId());
    row.createCell(columnIndex++).setCellValue(item.getName());
    row.createCell(columnIndex++).setCellValue(item.getValue());
    // ...
}

workbook.write(someOutputStream); // Write the Excel result to some output.
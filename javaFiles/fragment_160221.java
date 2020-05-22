List<String> values =  new ArrayList<String>();

FileInputStream stream = new FileInputStream("C:\\file.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(stream);
XSSFSheet worksheet = workbook.getSheetAt(0);
Iterator<Row> rows = worksheet.rowIterator();
while (rows.hasNext()) {
    Row row = rows.next();
    if(row.getRowNum() > 0) {                             // skip first row
        values.add(row.getCell(1).getStringCellValue());  // add the second cell
    }
}
stream.close();
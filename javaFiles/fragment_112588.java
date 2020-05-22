Workbook wb = WorkbookFactory.create(input);
Sheet sheet = wb.getSheetAt(0);
DataFormatter formatter = new DataFormatter();
for (Row r : sheet) {
   for (Cell c : r) {
       String value = formatter.formatCellValue(c);
   }
}
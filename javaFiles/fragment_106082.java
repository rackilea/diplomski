Workbook workbook = new XSSFWorkbook(inputStream);
Sheet firstSheet = workbook.getSheetAt(0);

for (Row row : firstSheet) {
  for (Cell cell : row) {
     // Do something here
  }
}
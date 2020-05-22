Workbook workbook = new HSSFWorkbook(); // or: new XSSFWorkbook() - depending on excel version

Sheet sheet = workbook.getSheetAt(i);
Row row = sheet.getRow(j);

Iterator iterator = row.cellIterator();

while(iterator.hasNext()){
     Cell cell = (Cell)iterator.next();

     // do whatever with cell...
}
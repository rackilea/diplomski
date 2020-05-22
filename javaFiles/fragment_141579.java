Workbook wb;
File newFile = new File("output.xlsx");
if (newFile.exists) { 
   // Load existing
   wb = WorkbookFactory.create(newFile);
} else {
   // What kind of file are they trying to ask for?
   // Add additional supported types here
   if (newFile.getName().endsWith(".xls")) {
      wb = new HSSFWorkbook();
   }
   else if (newFile.getName().endsWith(".xlsx")) {
      wb = new XSSFWorkbook();
   }
   else {
      throw new IllegalArgumentException("I don't know how to create that kind of new file");
   }
}
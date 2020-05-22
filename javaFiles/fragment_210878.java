File srcFile = new File("book.xls");
File destFile = new File("booktemp.xls");
try {
   Workbook destBook = WorkbookFactory.create(srcFile);
   FileOutputStream out = new FileOutputStream(destFile);
   destBook.write(out);
   out.close();
   destbook.close();  // Available in Apache POI 3.11!
} catch (Exception e) {
   e.printStackTrace();
}
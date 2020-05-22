final String path = "C:/Documents and Settings/eclipse/workspace/CompareExcelV2/";
Workbook outputWorkbook;
FileOutputStream outputTo;
if (fileA.endsWith(".xls") {
   outputWorkbook = new HSSFWorkbook();
   outputTo = new FileOutputStream(path + "output.xls");
} else {
   outputWorkbook = new XSSFWorkbook();
   outputTo = new FileOutputStream(path + "output.xlsx");
}
Workbook workbook1 = WorkbookFactory.create(new File(fileA));
Workbook workbook2 = WorkbookFactory.create(new File(fileB));
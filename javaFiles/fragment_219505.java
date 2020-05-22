final File file = "/tmp/sheet.xls";
final HSSFWorkbook workbook;
if (file.exists() == false) {
  System.out.println("Creating a new workbook '" + file + "'");
  workbook = new HSSFWorkbook();
} else {
  System.out.println("Appending to existing workbook '" + file + "'");
  final InputStream is = new FileInputStream(file);
  try {
    workbook = new HSSFWorkbook(is);
  } finally {
    is.close();
  }
}
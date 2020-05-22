if(xlFile.exists() && !xlFile.isDirectory())
    xlFile.delete(); //delete if file already exists.

if (xlFile.toString().endsWith(".xls") {
   workbook = new HSSFWorkbook();
} else {
   workbook = new XSSFWorkbook();
}
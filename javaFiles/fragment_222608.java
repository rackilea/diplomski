HSSFWorkbook workbook = new HSSFWorkbook();
try {
    FileOutputStream output = new FileOutputStream("Test1.xls");
    workbook.createSheet("sheet1")
    workbook.write(output);
    output.close();
} catch (Exception e) {
    e.printStackTrace();
}
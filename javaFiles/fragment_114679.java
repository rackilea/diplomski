try {
    String fileName = "file.xls";
    WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));
    workbook.createSheet("Sheet1", 0);
    workbook.createSheet("Sheet2", 1);
    workbook.createSheet("Sheet3", 2);
    workbook.write();
    workbook.close();
} catch (WriteException e) {

}
try {
    FileInputStream file = new FileInputStream(new File(
            "C:\\path\\Book1.xlsx"));

    XSSFWorkbook workbook = new XSSFWorkbook(file);
    XSSFSheet sheet = workbook.getSheetAt(0);
    XSSFSheet zip1 = workbook.createSheet("ZIP CODE 1");

    Row readFirstRow = sheet.getRow(0);
    Row writeFirstRow = zip1.createRow(0);

    for (Cell cell : readFirstRow) {

        cell.setCellType(Cell.CELL_TYPE_STRING);
        String a = cell.getStringCellValue();

        cell = writeFirstRow.createCell(cell.getColumnIndex());
        cell.setCellValue(a);
    }

    file.close();
    FileOutputStream outFile = new FileOutputStream(new File(
            "C:\\path\\BookOut.xlsx"));
    workbook.write(outFile);
    outFile.close();

} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}
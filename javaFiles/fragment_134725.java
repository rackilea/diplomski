System.out.println("started");

    XSSFWorkbook workbook = new XSSFWorkbook();
    XSSFSheet sheet = workbook.createSheet();
    XSSFRow row = sheet.createRow(0);
    XSSFCell cell = row.createCell(0);

    cell.setCellValue(3.14159);
    cell.setCellType(XSSFCell.CELL_TYPE_STRING);

    XSSFDataFormat format = workbook.createDataFormat();
    XSSFCellStyle style = workbook.createCellStyle();
    style.setDataFormat(format.getFormat("Text"));

    cell.setCellStyle(style);

    workbook.write(new FileOutputStream("Test.xlsx"));

    System.out.println("finished");
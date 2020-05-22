public void readfile(String filepath, String filename, String sheetname)    throws IOException {


    File file = new File(filepath+"\\"+filename);
    FileInputStream fis = new FileInputStream(file);

    // for creating .xlsx workbook
    Workbook wb = new XSSFWorkbook(fis);

    // for reading the sheet by its name
    Sheet sh = wb.getSheet(sheetname);

    // find the total rows in sheet

    int rowcount = sh.getLastRowNum() - sh.getFirstRowNum();

    // create a loop to create

    for (int i = 0; i < rowcount + 1; i++) {
        Row row = sh.getRow(i);

        // create a loop to print cell values

        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            switch (cell.getCellType()) {
            case Cell.CELL_TYPE_STRING:
                System.out.print(row.getCell(j).getStringCellValue() + " ");
                break;

            case Cell.CELL_TYPE_NUMERIC:
                System.out.print((int)row.getCell(j).getNumericCellValue() + " ");
                break;

            }

        }

        System.out.println();
    }

}
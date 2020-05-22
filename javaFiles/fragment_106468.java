public List<Record> readBooksFromExcelFile(String excelFilePath)
        throws IOException {

    List<Record> listBooks = new ArrayList<Record>();
    FileInputStream inputStream = new FileInputStream(new File(
            excelFilePath));

    Workbook workbook = new XSSFWorkbook(inputStream);
    Sheet firstSheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = firstSheet.iterator();

    FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator(
            (XSSFWorkbook) workbook);
    DataFormatter objDefaultFormat = new DataFormatter();
    String cellValueStr;

    int headingRow = 0;

    System.out
            .println("================== Start Reading Records From Excel ==================");
    LogFileWriter
            .appendToLogfile(
                    "================== Start Reading Records From Excel ==================",
                    true);

    while (iterator.hasNext()) {

        Row nextRow = iterator.next();
        // to ignore the first row.

        if (headingRow == 0) {
            headingRow++;
            continue;
        }
        Iterator<Cell> cellIterator = nextRow.cellIterator();
        Record aRecord = new Record();

        while (cellIterator.hasNext()) {
            Cell nextCell = cellIterator.next();
            nextCell.setCellType(Cell.CELL_TYPE_STRING);
            int columnIndex = nextCell.getColumnIndex();

            // to ignore the heading row in file.

            switch (columnIndex) {
            case 0:
                // objFormulaEvaluator.evaluate(nextCell);
                // cellValueStr =
                // objDefaultFormat.formatCellValue(nextCell,objFormulaEvaluator);

                cellValueStr = (String) getCellValue(nextCell);
                cellValueStr = cellValueStr.replace(" ", "");
                aRecord.setIccid(cellValueStr);

                // aRecord.setIccid((String) getCellValue(nextCell));
                break;
            case 1:
                // objFormulaEvaluator.evaluate(nextCell);
                // cellValueStr =
                // objDefaultFormat.formatCellValue(nextCell,objFormulaEvaluator);
                // cellValueStr=cellValueStr.replace(" ", "");

                cellValueStr = (String) getCellValue(nextCell);
                cellValueStr = cellValueStr.replace(" ", "");
                aRecord.setApn(cellValueStr);
                break;
            case 2:
                // objFormulaEvaluator.evaluate(nextCell);
                // cellValueStr =
                // objDefaultFormat.formatCellValue(nextCell,objFormulaEvaluator);
                // cellValueStr=cellValueStr.replace(" ", "");

                cellValueStr = (String) getCellValue(nextCell);
                cellValueStr = cellValueStr.replace(" ", "");
                aRecord.setIpAddress(cellValueStr);
                break;
            case 3:
                // objFormulaEvaluator.evaluate(nextCell);
                // cellValueStr =
                // objDefaultFormat.formatCellValue(nextCell,objFormulaEvaluator);
                // cellValueStr=cellValueStr.replace(" ", "");

                cellValueStr = (String) getCellValue(nextCell);
                cellValueStr = cellValueStr.replace(" ", "");
                aRecord.setPdp(cellValueStr);
                break;
            }
        }

        System.out.println("READ: " + aRecord.toString());
        LogFileWriter.appendToLogfile("READ: " + aRecord.toString(), true);
        listBooks.add(aRecord);
    }
    // workbook.close();
    System.out.println("================== Finished Reading Records From Excel ==================");
    LogFileWriter.appendToLogfile("================== Finished Reading Records From Excel ==================",true);
    return listBooks;
}

private Object getCellValue(Cell cell) {

    switch (cell.getCellType()) {
    case Cell.CELL_TYPE_STRING:
        return cell.getStringCellValue();

    case Cell.CELL_TYPE_BOOLEAN:
        return cell.getBooleanCellValue();

    case Cell.CELL_TYPE_NUMERIC:
        return cell.getNumericCellValue();
    }

    return null;
}
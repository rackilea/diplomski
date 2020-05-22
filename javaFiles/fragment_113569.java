private void writingToExcel(WritableWorkbook workbook) {
    try {
        // don't create a sheet now, instead, pass it in the workbook
        createContent(workbook);
    }
    catch (WriteException e) {
        e.printStackTrace();
    }
    finally {
        try {
            workbook.write();
            workbook.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (WriteException e) {
            e.printStackTrace();
        }

    }
}

// instead of taking a sheet, take a workbook because we cannot ensure if the sheet can fit all the content at this point
private void createContent(WritableWorkbook workbook) throws WriteException {

    int excelSheetIndex = 0;
    int rowIndex = 0;
    WritableSheet excelSheet = null;

    for (int i = 1; i < 70000; i++) {

        // if the sheet has hit the cap, then create a new sheet, new label row and reset the row count
        if (excelSheet == null || excelSheet.getRows() == 65536) {
            excelSheet = workbook.createSheet("Report " + excelSheetIndex, excelSheetIndex++);
            createLabel(excelSheet);
            rowIndex = 0;
        }

        // instead of using i for row, use rowIndex
        addNumber(excelSheet, 0, rowIndex, i + 10);
        addNumber(excelSheet, 1, rowIndex, i * i);

        // increment the sheet row
        rowIndex++;
    }
}
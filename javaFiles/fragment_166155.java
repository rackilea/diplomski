File file = new File(inFileName);
Workbook workBook = WorkbookFactory.create(file);
Sheet sheet  = workBook.getSheetAt(0);

int rowCtr = 33;
Row myRow = sheet.getRow(rowCtr++);
while (myRow != null) {
    Cell cell1 = myRow.getCell(0);
    // rest of your loop code

    myRow = sheet.getRow(rowCtr++);
}
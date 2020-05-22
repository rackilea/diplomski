String toFind = "needle in haystack";

Workbook wb = WorkbookFactory.create(new File("input.xlsx"));
DataFormatter formatter = new DataFormatter();
Sheet sheet1 = wb.getSheetAt(0);
for (Row row : sheet1) {
    for (Cell cell : row) {
        CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());

        // get the text that appears in the cell by getting the cell value and applying any data formats (Date, 0.00, 1.23e9, $1.23, etc)
        String text = formatter.formatCellValue(cell);

        // is it an exact match?
        if (toFind.equals(text)) {
           System.out.println("Text matched at " + cellRef.formatAsString());
        }
        // is it a partial match?
        else if (text.contains(toFind)) {
           System.out.println("Text found as part of " + cellRef.formatAsString());
        }
    }
}
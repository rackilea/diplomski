/**
 * Opens an existing sheet or creates a new one if the given sheet name doesn't exist. 
 * Appends values after the last existing row.
 */
public static void main(String[] args) throws IOException {
    XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\Administrator\\Desktop\\test.xlsx");
    Sheet sheet = workbook.getSheet("Sheet1");
    if (sheet == null)
        sheet = workbook.createSheet("Sheet1");

    Object[][] values = {{"A2", "B2", "C2"}, {"A3","B3","C3","D3"}};
    int initRow = sheet.getLastRowNum() + 1;
    int initCol = 0;
    for (int i = 0; i < values.length; i++) {
        Object[] rowValues = values[i];
        for (int j = 0; j < rowValues.length; j++) {
            Object value = rowValues[j];
            writeValueToCell(value, initRow + i, initCol + j, sheet);
        }
    }

    try {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\output.xlsx");
        workbook.write(fos);
        fos.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void writeValueToCell(Object value, int rowIdx, int colIdx, Sheet sheet) {
    Row row = sheet.getRow(rowIdx);
    Cell cell;
    if (row == null) {
        cell = sheet.createRow(rowIdx).createCell(colIdx);
    } else {
        cell = row.getCell(colIdx);
        if (cell == null)
            cell = row.createCell(colIdx);
    }

    if (value == null)
        cell.setCellType(Cell.CELL_TYPE_BLANK);
    else if (value instanceof String)
        cell.setCellValue(value.toString());
    else if (value instanceof Integer)
        cell.setCellValue((Integer) value);
    else if (value instanceof Double)
        cell.setCellValue((Double) value);
    else if (value instanceof Date) {
        cell.setCellValue((Date) value);
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setDataFormat(sheet.getWorkbook().getCreationHelper().createDataFormat().getFormat(("yyyy/m/d")));
        cell.setCellStyle(style);
    } else {
        cell.setCellValue("Unknown type");
    }
}
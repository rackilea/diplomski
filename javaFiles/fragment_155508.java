public static int getNumberOfNonEmptyCells(XSSFSheet sheet,int columnIndex) {
        int numberOfNonEmptyCells = 0;
        for (int i = 0; i <= sheet.getLastRowNum();i++) {
            XSSFRow row = sheet.getRow(i);
            if (row != null) {
                XSSFCell cell = row.getCell(columnIndex);
                if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK) {
                    numberOfNonEmptyCells++;
                }
            }
        }
        return numberOfNonEmptyCells;
    }
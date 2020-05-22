private static int findRow(HSSFSheet sheet, String cellContent) {
    for (Row row : sheet) {
        for (Cell cell : row) {
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                    return row.getRowNum();  
                }
            }
        }
    }               
    return 0;
}
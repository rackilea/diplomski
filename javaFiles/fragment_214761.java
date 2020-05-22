switch (cell.getCellType()) {
    case HSSFCell.CELL_TYPE_NUMERIC:
        if(DateUtil.isCellDateFormatted(cell)) {
            cellValue = new DataFormatter().formatCellValue(cell);
        } else {
            cellValue = String.valueOf((int) (cell.getNumericCellValue()));
        }
        break;
    case HSSFCell.CELL_TYPE_STRING:
        cellValue = cell.getStringCellValue();
        break;
}
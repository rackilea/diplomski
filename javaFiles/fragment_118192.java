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
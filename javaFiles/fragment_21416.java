Cell cell = rowAmt.getCell(0);
if (cell != null) {
    System.out.println(cell.getStringCellValue());
    /*
     * for numbers: cell.getNumericCellValue();
     * for booleans: cell.getBooleanCellValue();
     */
}
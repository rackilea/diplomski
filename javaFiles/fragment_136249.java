// get the cell as object (this is NOT a number, instead, it contains one)
HSSFCell numberCell = sheet.getRow(1).getCell(26);
// get the cell value as double (there is no direct integer version)
double cellValue = numberCell.getNumericCellValue();
// cast the value to an int
int number = (int) cellValue;
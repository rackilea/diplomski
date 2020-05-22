for (int rowNum = 5; rowNum < sheet.getRows(); rowNum++) {
int column = 4;
  sheet.getCell(column ++, rowNum).getContents(); //read 4th column and 5th row into a variable or object as per your logic;
  sheet.getCell(column ++, rowNum).getContents(); //read 5th column and 5th row;
  ......
}
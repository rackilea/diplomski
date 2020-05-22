int numberOfRows = // what you neeed

for (int i = 0; i < numberOfRows; i+=9) {
    String value = workbook.getSheet(0).getCell(1, i).getContents();
    System.out.println(value);
}
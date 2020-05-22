int row = 0;

while (row < 5) {
    Row r = sheet.createRow(row);
    for (int column = 0; column < 5; column++) {
        cell = r.createCell(column);
        cell.setCellValue(row + "," + column);
    }
    row++;
}
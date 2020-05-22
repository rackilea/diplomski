for (int i = 0; i < listOfResults.size(); i++) {
    row = sheet.createRow(i);
    for (int j = 0; j < 7; j++) {
        cell = row.createCell(j);
        if (j + add < listOfResults.size()) {
            cell.setCellValue(listOfResults.get(j + add));
        }
    }
    add += 7;
}
for (int i = 0; i < a1.size(); i++) {
    int rowIndex = a1.get(i);
    int colIndex = a2.get(i);
    XSSFRow BOFF = sheet.getRow(rowIndex);
    if (BOFF.getCell(colIndex) != null) {
        BOFF.getCell(colIndex).setCellStyle(offcolor);
    } else {
        Cell cell1 = BOFF.createCell(colIndex);
        cell1.setCellStyle(offcolor);
    }
}
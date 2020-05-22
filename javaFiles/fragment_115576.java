for (CellAddress xCellAddress : xCellAddresses) {
    XSSFRow BOFF = sheet.getRow(xCellAddress.getRow());
    if (BOFF.getCell(xCellAddress.getColumn()) != null) {
        BOFF.getCell(xCellAddress.getColumn()).setCellStyle(offcolor);
    } else {
        Cell cell1 = BOFF.createCell(xCellAddress.getColumn());
        cell1.setCellStyle(offcolor);
    }
}
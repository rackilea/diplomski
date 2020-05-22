for (int i = 0 ; i < numrows ; i++){
    for (int j = 0 ; j < numcols ; j++){
        readCell = sheet.getCell(i, j);
        newCell = readCell.copyTo(i, j);
        readFormat = readCell.getCellFormat();
        newFormat = new WritableCellFormat(readFormat);
        newCell.setCellFormat(newFormat);
        newSheet.add(newCell);
    }
}
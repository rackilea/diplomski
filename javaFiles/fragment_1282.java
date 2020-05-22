//iterates lines, then iterate each column giving style to each cell
for (int r=1; r<sheet.getLastRowNum(); r++) {
    HSSFRow row = sheet.getRow(r);
    for (int i=0; i<row.getPhysicalNumberOfCells(); i++) {
        row.getCell(i).setCellStyle(styleCellWhite);
    }
}
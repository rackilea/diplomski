if (row.getRowNum() == 0) {
    row.createCell(cellsNum).setCellValue("GUID");
} else {
    System.out.println((row.getRowNum())); // row number for each cell?
    row.createCell(cellsNum).setCellValue(guids.get((row.getRowNum())));
}
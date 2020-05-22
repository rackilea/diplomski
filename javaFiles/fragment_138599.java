public Integer  Check4(int b) throws IOException  {
    InputStream myxls = new FileInputStream("book.xls");
    HSSFWorkbook wb     = new HSSFWorkbook(myxls);
    HSSFSheet sheet = wb.getSheetAt(0);       // first sheet
    HSSFRow row     = sheet.getRow(1);        // first row
    //HSSFCell cell0   = row.getCell((short)a);  // first arg
    HSSFCell cell1   = row.getCell((short)b);  // second arg
    String sell = cell1.toString();
    cell1.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
    System.out.println("smth "+ (int) Math.round(cell1.getNumericCellValue()));
    return  (int) Math.round(cell1.getNumericCellValue());

}
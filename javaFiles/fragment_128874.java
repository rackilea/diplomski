FileInputStream fis =null;
     Workbook workbook=null;
    public void openWorkbook(){
         fis = new FileInputStream(path);
         workbook = WorkbookFactory.create(fis);
    }

    public boolean updateCellData(ColumnName, RowNum, Data){

            row =  getRow(rowNum-1);
                if (row == null){
                    row = sheet.createRow(rowNum-1);
                }
                cell = row.getCell(colNum);
                if (cell == null){
                    cell = row.createCell(colNum);
                }
                cell.setCellValue(data);
      }

    public void closeWorkbook(){
        fileOut = new FileOutputStream(path);
        workbook.write(fileOut);
        fileOut.close();
    }
InputStream excelFile = new FileInputStream(file);
    Workbook workbook = new XSSFWorkbook(excelFile);
    ArrayList colsList=new ArrayList();
    colsList.add("Col1");
    colsList.add("Col2");
    colsList.add("Col3");
    colsList.add("Col4");
    Sheet datatypeSheet = workbook.getSheetAt(0);
    int numOfRows=datatypeSheet.getLastRowNum();
    for(int rowNum=0;rowNum<numOfRows;rowNum++){
    Row row=datatypeSheet.getRow(rowNum);
    int numOfCellPerRow=row.getLastCellNum();
    for(int cellNum=0;cellNum<numOfCellPerRow;cellNum++){
    if(colsList.contains(row.getCell(rowNum).getStringCellValue())){
    Cell cell=row.getCell(cellNum)
    System.out.println("Cell No:"+cellNum+" value is: 
    "+cell.getStringCellValue())
    }
   }
     System.out.println("This is a new Row");
   }
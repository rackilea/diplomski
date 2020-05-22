int currentRow = 0;
for (int rowNum = 0; rowNum < excelData.size(); rowNum++) 
{
  ArrayList<String> rowData = excelData.get(rowNum);

  if(currentRow == 1000)
  {
    sheetName = "Document-" + (rowNum/1000);
    mySheet = myWorkBook.createSheet();
    currentRow = 0;
  }
  myRow = mySheet.createRow(currentRow);
  for (int cellNum = 0; cellNum < rowData.size(); cellNum++) 
  {
    myCell = myRow.createCell(cellNum);
    myCell.setCellValue(rowData.get(cellNum));
  }

  currentRow++;
}
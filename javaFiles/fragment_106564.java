XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("sample.xlsx")); 
XSSFSheet sheet = wb.getSheetAt(0);

//the following creates a Pivot Table with 3 PivotFields (0 to 2) (3 Columns A3:C7); all dataField="false" at first 
XSSFPivotTable pivotTable = sheet.createPivotTable(new AreaReference(new CellReference("A3"), new CellReference("C7")), new CellReference("E3"));

//the following makes PivotFields(0) an Axis-Field AXIS_ROW with 5 Items (5 Rows A3:C7). Why one Item for each row? I don't know.
//and it adds a new RowField for this
pivotTable.addRowLabel(0);

//the following makes PivotFields(1) a DataField and creates a DataColumn for this
pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
//pivotTable.addDataColumn(2, false); //not neccessary since addColumnLabel already adds a DataColumn

//now PivotFields(2) needs to be an Axis-Field AXIS_COL
pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).setAxis(
  org.openxmlformats.schemas.spreadsheetml.x2006.main.STAxis.AXIS_COL);

//PivotFields(2) needs to have at least one Item  
pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).addNewItems();
pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(2).getItems().addNewItem().setT(
  org.openxmlformats.schemas.spreadsheetml.x2006.main.STItemType.DEFAULT);

//new ColField needs to be added
pivotTable.getCTPivotTableDefinition().addNewColFields().addNewField().setX(2);

//pivotTable.addReportFilter(2);
FileOutputStream fileOut = new FileOutputStream("output.xlsx");
wb.write(fileOut);
fileOut.close();
wb.close();
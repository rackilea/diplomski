import java.io.FileOutputStream;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.*;

class CreatePivotTableCalculatedFields {

 public static void main(String[] args) throws Exception {
  createPivotTable();
 }

 private static void createPivotTable() throws Exception {
  try (XSSFWorkbook wb = new XSSFWorkbook(); 
       FileOutputStream fileOut = new FileOutputStream("Output.xlsx")) {

   XSSFSheet dataSheet = wb.createSheet("1econtent");
   XSSFSheet pivotSheet = wb.createSheet("1e");

   setCellData(dataSheet, wb);

   AreaReference source = new AreaReference("A1:F5", SpreadsheetVersion.EXCEL2007);
   CellReference position = new CellReference(0,0);

   XSSFPivotTable pivotTable = pivotSheet.createPivotTable(source, position,wb.getSheet("1econtent"));
   pivotTable.addRowLabel(2);
   pivotTable.addRowLabel(0);

   pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 3);

   pivotSheet.setDisplayGridlines(false);

   wb.setSelectedTab(1);
   wb.setActiveSheet(1);

   // customize pivot table
   CTCacheFields ctCacheFields = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields();
   CTCacheField ctCacheField = ctCacheFields.addNewCacheField();
   ctCacheField.setName("Field");
   ctCacheField.setFormula("'Actuals' / 'Estimates'");
   ctCacheField.setDatabaseField(false);
   ctCacheFields.setCount(ctCacheFields.sizeOfCacheFieldArray());

   CTPivotField pivotField = pivotTable.getCTPivotTableDefinition().getPivotFields().addNewPivotField();
   pivotField.setDataField(true);
   pivotField.setDragToCol(false);
   pivotField.setDragToPage(false);
   pivotField.setDragToRow(false);
   pivotField.setShowAll(false);
   pivotField.setDefaultSubtotal(false);

   CTDataFields dataFields;
   if(pivotTable.getCTPivotTableDefinition().getDataFields() != null) {
    dataFields = pivotTable.getCTPivotTableDefinition().getDataFields();
   } else {
    dataFields = pivotTable.getCTPivotTableDefinition().addNewDataFields();
   }
   CTDataField dataField = dataFields.addNewDataField();
   dataField.setName("Calculated Field");
   dataField.setFld(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCount()-1);
   dataField.setBaseItem(0);
   dataField.setBaseField(0);
   DataFormat dataformat =  pivotTable.getParentSheet().getWorkbook().createDataFormat();
   short numFmtId = dataformat.getFormat("0.0%");
   dataField.setNumFmtId(numFmtId);

   // at least one field in colFields is needed if there are multiple data fields
   CTColFields colFields;
   if(pivotTable.getCTPivotTableDefinition().getColFields() != null) {
    colFields = pivotTable.getCTPivotTableDefinition().getColFields();
   } else {
    colFields = pivotTable.getCTPivotTableDefinition().addNewColFields();
   }
   CTField field;
   if (colFields.getFieldList().size() == 0) {
    field = colFields.addNewField();
    field.setX(-2);
   }

   wb.write(fileOut);
  }
 }

 public static void setCellData(XSSFSheet sheet, XSSFWorkbook wb){
  Object[][] data = new Object[][] {
   new Object[] {"Names", "Age", "Dept", "Salary", "Actuals", "Estimates"},
   new Object[] {"Adam", 22d, "Sales", 10d, 12d, 60d},
   new Object[] {"Bran", 24d, "Finance", 20d, 24d, 60d},
   new Object[] {"Jane", 23d, "IT", 30d, 30d, 60d},
   new Object[] {"Dave", 30d, "Sales", 50d, 6d, 60d}
  };

  XSSFRow row;
  XSSFCell cell;
  for (int r = 0; r < data.length; r++) {
   row = sheet.createRow(r);
   for (int c = 0 ; c < data[r].length; c++) {
    cell = row.createCell(c);
    if (data[r][c] instanceof String) {
     cell.setCellValue((String)data[r][c]);
    } else if (data[r][c] instanceof Double) {
     cell.setCellValue((Double)data[r][c]);
    }
   }
  }
 } 
}
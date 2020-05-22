import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import java.io.*;

class PivotTableTest5 {

 private static void setCellData(Sheet sheet) {
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);
  cell.setCellValue("Name");
  cell = row.createCell(1);
  cell.setCellValue("City");

  for (int r = 1; r < 15; r++) {
   row = sheet.createRow(r);
   cell = row.createCell(0);
   cell.setCellValue("Name " + ((r-1) % 4 + 1));
   cell = row.createCell(1);
   cell.setCellValue("City " + (int)((new java.util.Random().nextDouble() * 3)+1) );  
  }
 }

 public static void main(String[] args) {
  try {
   XSSFWorkbook wb = new XSSFWorkbook();
   XSSFSheet sheet = wb.createSheet();

   //Create some data to build the pivot table on
   setCellData(sheet);

   XSSFPivotTable pivotTable = sheet.createPivotTable(
    new AreaReference(new CellReference("A1"), new CellReference("B15")), new CellReference("H5"));
   //Count the second column. This needs to be second column a data field.
   pivotTable.addColumnLabel(DataConsolidateFunction.COUNT, 1);
   //Use second column as row label
   pivotTable.addRowLabel(1);
   //Apache poi sets pivot field 1 (second column) only to be axisRow but it needs to be dataField too.
   pivotTable.getCTPivotTableDefinition().getPivotFields().getPivotFieldArray(1).setDataField(true);

   FileOutputStream fileOut = new FileOutputStream("PivotTableTest5.xlsx");
   wb.write(fileOut);
   fileOut.close();
   wb.close();
  } catch (FileNotFoundException e) {
    e.printStackTrace();
  } catch (IOException e) {
    e.printStackTrace();
  }
 }
}
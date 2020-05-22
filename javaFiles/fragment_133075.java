import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.SpreadsheetVersion;

import org.apache.poi.xssf.streaming.*;

import java.util.Random;
import java.io.FileOutputStream;

class SXSSFPivotTableTest {

 private static void streamCellData(Sheet sheet, int rowsCount) {

  for (int r = 1; r <= rowsCount; r++) {
   Row row = sheet.createRow(r);
   Cell cell = row.createCell(0);
   cell.setCellValue("Name " + ((r-1) % 4 + 1));
   cell = row.createCell(1);
   cell.setCellValue(r * new java.util.Random().nextDouble());
   cell = row.createCell(2);
   cell.setCellValue(r * new java.util.Random().nextDouble());
   cell = row.createCell(3);
   cell.setCellValue("City " + ((r-1) % 3 + 1));  
  }

 }

 public static void main(String[] args) throws Exception{

  int rowsCount = 1000000;

  //first create XSSFWorkbook
  XSSFWorkbook wb = new XSSFWorkbook();

  //create XSSFSheet with at least the headings
  XSSFSheet sheet = wb.createSheet("Sheet1");
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);
  cell.setCellValue("Name");
  cell = row.createCell(1);
  cell.setCellValue("Value1");
  cell = row.createCell(2);
  cell.setCellValue("Value2");
  cell = row.createCell(3);
  cell.setCellValue("City");

  //create XSSFSheet for pivot table
  XSSFSheet pivotSheet = wb.createSheet("Pivot sheet");

  //create pivot table
  XSSFPivotTable pivotTable = pivotSheet.createPivotTable(
    new AreaReference(new CellReference("Sheet1!A1"), 
                      new CellReference("Sheet1!D" + (rowsCount +1)), //make the reference big enough for later data
                      SpreadsheetVersion.EXCEL2007),
    new CellReference("A5"));
  //Configure the pivot table
  //Use first column as row label
  pivotTable.addRowLabel(0);
  //Sum up the second column
  pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1);
  //Avarage the third column
  pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 2);
  //Add filter on forth column
  pivotTable.addReportFilter(3);

  //now create SXSSFWorkbook from XSSFWorkbook
  SXSSFWorkbook swb = new SXSSFWorkbook(wb);
  SXSSFSheet ssheet = swb.getSheet("Sheet1");

  //now stream the big amount of data to build the pivot table on into Sheet1
  streamCellData(ssheet, rowsCount);

  swb.write(new FileOutputStream("SXSSFPivotTableTest.xlsx"));
  swb.close();
  swb.dispose();

 }
}
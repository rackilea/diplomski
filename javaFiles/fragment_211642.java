import java.io.FileOutputStream;

import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;

import java.util.GregorianCalendar;

class CreatePivotTable {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   DataFormat format = workbook.createDataFormat();
   CellStyle dateStyle = workbook.createCellStyle();
   dateStyle.setDataFormat(format.getFormat("M\\/d\\/yy"));

   Sheet sheet = workbook.createSheet();

   String[] headers = new String[]{"Column1", "Column2", "Date", "Count"};
   Row row = sheet.createRow(0);
   Cell cell;
   for (int c = 0; c < headers.length; c++) {
    cell = row.createCell(c); cell.setCellValue(headers[c]);
   }

   Object[][] data = new Object[][]{
    new Object[]{"A", "B", new GregorianCalendar(2019, 0, 1), 2d},
    new Object[]{"A", "B", new GregorianCalendar(2019, 0, 1), 4d},
    new Object[]{"A", "B", new GregorianCalendar(2019, 0, 2), 1d},
    new Object[]{"A", "B", new GregorianCalendar(2019, 0, 2), 7d},
    new Object[]{"A", "C", new GregorianCalendar(2019, 0, 1), 5d},
    new Object[]{"A", "C", new GregorianCalendar(2019, 0, 1), 5d},
    new Object[]{"A", "C", new GregorianCalendar(2019, 0, 2), 2d},
    new Object[]{"A", "C", new GregorianCalendar(2019, 0, 2), 8d}
   };
   for (int r = 0; r < data.length; r++) {
    row = sheet.createRow(r+1);
    Object[] rowData = data[r];
    for (int c = 0; c < rowData.length; c++) {
     cell = row.createCell(c);
     if (rowData[c] instanceof String) {
      cell.setCellValue((String)rowData[c]);
     } else if (rowData[c] instanceof GregorianCalendar) {
      cell.setCellValue((GregorianCalendar)rowData[c]);
      cell.setCellStyle(dateStyle);
     } else if (rowData[c] instanceof Double) {
      cell.setCellValue((Double)rowData[c]);
     }
    }
   }

   XSSFPivotTable pivotTable = ((XSSFSheet)sheet).createPivotTable(new AreaReference("A1:D9", SpreadsheetVersion.EXCEL2007), new CellReference("M10"));

   pivotTable.addRowLabel(0);
   pivotTable.addRowLabel(1);

   pivotTable.addColLabel(2);

   // the default sets data on columns and data fields as col fields
   pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 3);
   pivotTable.addColumnLabel(DataConsolidateFunction.AVERAGE, 3);

   // now changing from the default
   // set dataOnRows
   pivotTable.getCTPivotTableDefinition().setDataOnRows(true);

   // add a new row field for data fields 
   pivotTable.getCTPivotTableDefinition().getRowFields().addNewField().setX(-2);
   pivotTable.getCTPivotTableDefinition().getRowFields().setCount(3);

   // remove data fields from col fields
   pivotTable.getCTPivotTableDefinition().getColFields().removeField(1);
   pivotTable.getCTPivotTableDefinition().getColFields().setCount(1);

   workbook.write(fileout);

  }

 }
}
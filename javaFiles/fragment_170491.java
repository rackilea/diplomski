import java.io.FileOutputStream;

import org.apache.poi.ss.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.*;

class CreatePivotTableStyle {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   Sheet pivotSheet = workbook.createSheet("Pivot");
   Sheet dataSheet = workbook.createSheet("Data");

   Row row;
   Cell cell;
   Object[][] data = new Object[][]{
    new Object[]{"Name", "Count"},
    new Object[]{"A", 2d},
    new Object[]{"B", 4d},
    new Object[]{"A", 1d},
    new Object[]{"B", 7d}
   };
   for (int r = 0; r < data.length; r++) {
    row = dataSheet.createRow(r);
    Object[] rowData = data[r];
    for (int c = 0; c < rowData.length; c++) {
     cell = row.createCell(c);
     if (rowData[c] instanceof String) {
      cell.setCellValue((String)rowData[c]);
     } else if (rowData[c] instanceof Double) {
      cell.setCellValue((Double)rowData[c]);
     }
    }
   }

   AreaReference arerReference = new AreaReference("A1:B5", SpreadsheetVersion.EXCEL2007);

   XSSFPivotTable pivotTable = ((XSSFSheet)pivotSheet).createPivotTable(arerReference, new CellReference("A4"), dataSheet);

   pivotTable.addRowLabel(0);
   pivotTable.addColumnLabel(DataConsolidateFunction.SUM, 1, "Sum of count");

   pivotTable.getCTPivotTableDefinition().getPivotTableStyleInfo().setName("PivotStyleMedium7");

   workbook.write(fileout);

  }

 }
}
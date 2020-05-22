import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CreateExcelCellAccountingStyle {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("Excel.xlsx") ) {

   Object[][] data = new Object[][] {
    new Object[] {"Text", "Value"},
    new Object[] {"Value 1", 123.456789},
    new Object[] {"Value 2", 1234.56789}
   };

   DataFormat dataFormat = workbook.createDataFormat();
   CellStyle cellAccountingStyle = workbook.createCellStyle();
   //cellAccountingStyle.setDataFormat(dataFormat.getFormat("_ [$€-nl-NL] * #,##0.00_ ;_ [$€-nl-NL] * -#,##0.00_ ;_ [$€-nl-NL] * \"-\"??_ ;_ @_ "));
   cellAccountingStyle.setDataFormat(dataFormat.getFormat("_ [$€-413] * #,##0.00_ ;_ [$€-413] * -#,##0.00_ ;_ [$€-413] * \"-\"??_ ;_ @_ "));

   Sheet sheet = workbook.createSheet(); 

   for (int r = 0; r < data.length; r++) {
    Row row = sheet.createRow(r);
    for (int c = 0; c < data[0].length; c++) {
     Cell cell = row.createCell(c);
     if (data[r][c] instanceof String) {
      cell.setCellValue((String)data[r][c]);
     } else if (data[r][c] instanceof Double) {
      cell.setCellValue((Double)data[r][c]);
      cell.setCellStyle(cellAccountingStyle);
     }
    }
   }

   for (int c = 0; c < data[0].length; c++) {
    sheet.autoSizeColumn(c);
   }

   workbook.write(fileout);
  }

 }
}
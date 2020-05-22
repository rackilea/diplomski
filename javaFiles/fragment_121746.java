import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.PropertyTemplate;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class ExcelDrawingBorders {

 public static void main(String[] args) throws Exception {

  try (Workbook workbook = new XSSFWorkbook(); 
       FileOutputStream fileout = new FileOutputStream("ExcelDrawingBorders.xlsx") ) {

   int startDataRow = 4;
   int endDataRow = 8;
   int startDataColumn = 2;
   int endDataColumn = 6;

   Sheet sheet = workbook.createSheet();

   for (int r = startDataRow; r <= endDataRow; r++) {
    Row row = sheet.createRow(r);
    for (int c = startDataColumn; c <= endDataColumn; c++) {
     Cell cell = row.createCell(c);
     cell.setCellFormula("RANDBETWEEN(10,50)");
    }
   }

   PropertyTemplate propertyTemplate = new PropertyTemplate();
   propertyTemplate.drawBorders(new CellRangeAddress(startDataRow-1, endDataRow+1, startDataColumn-1, endDataColumn+1), 
    BorderStyle.MEDIUM, BorderExtent.OUTSIDE);

   propertyTemplate.applyBorders(sheet);

   workbook.write(fileout);

  }
 }
}
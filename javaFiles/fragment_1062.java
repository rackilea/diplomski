import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelCellStyleRedAndGreen {

 public static void main(String[] args) throws Exception {
  //Workbook workbook = new XSSFWorkbook();
  Workbook workbook = new HSSFWorkbook();

  CellStyle headerCellStyleRed = workbook.createCellStyle();
  CellStyle headerCellStyleGreen = workbook.createCellStyle();

  headerCellStyleRed.setWrapText(true);
  headerCellStyleRed.setFillPattern(FillPatternType.SOLID_FOREGROUND);
  headerCellStyleRed.setAlignment(HorizontalAlignment.JUSTIFY);
  headerCellStyleRed.setVerticalAlignment(VerticalAlignment.CENTER);

  headerCellStyleGreen.cloneStyleFrom(headerCellStyleRed);

  headerCellStyleRed.setFillForegroundColor(IndexedColors.RED.getIndex());
  headerCellStyleGreen.setFillForegroundColor(IndexedColors.GREEN.getIndex());

  String[] arr = new String[] {
   "A Name of File.xml", 
   "B Name of File.xml*", 
   "C Name of File.xml", 
   "D Name of File.xml", 
   "E Name of File.xml*", 
   "F Name of File.xml"
  };

  int rowNum=1;
  int colNum=1;

  Sheet sheet = workbook.createSheet();

  for (int i = 0; i < arr.length; i++) {
   Row row = sheet.createRow(rowNum++);
   Cell cell = row.createCell(colNum);
   if (arr[i].contains("*")) {
    //RED
    cell.setCellStyle(headerCellStyleRed);
    cell.setCellValue(arr[i].replace(".xml*", ""));

   } else {
    //GREEN
    cell.setCellStyle(headerCellStyleGreen);
    cell.setCellValue(arr[i].replace(".xml", ""));
   }
   row.setHeightInPoints(50);
  }

  FileOutputStream out = null;
  if (workbook instanceof HSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCellStyleRedAndGreen.xls");
  } else if (workbook instanceof XSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCellStyleRedAndGreen.xlsx");
  }
  workbook.write(out);
  out.close();
  workbook.close();
 }
}
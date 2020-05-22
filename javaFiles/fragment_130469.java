import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.hssf.util.HSSFColor;

public class ReadExcelColorHavingTint {

 private static String getFillColorHex(Cell cell) throws Exception { 
  String fillColorString = "none";
  if (cell != null) {
   CellStyle cellStyle = cell.getCellStyle();
   Color color =  cellStyle.getFillForegroundColorColor();
   if (color instanceof XSSFColor) {
    XSSFColor xssfColor = (XSSFColor)color;
    byte[] argb = xssfColor.getARGB();
    fillColorString = "[" + (argb[0]&0xFF) + ", " + (argb[1]&0xFF) + ", " + (argb[2]&0xFF) + ", " + (argb[3]&0xFF) + "]";
    if (xssfColor.hasTint()) {
     fillColorString += " * " + xssfColor.getTint();
     byte[] rgb = xssfColor.getRGBWithTint();
     fillColorString += " = [" + (argb[0]&0xFF) + ", " + (rgb[0]&0xFF) + ", " + (rgb[1]&0xFF) + ", " + (rgb[2]&0xFF) + "]" ;
    }
   } else if (color instanceof HSSFColor) {
    HSSFColor hssfColor = (HSSFColor)color;
    short[] rgb = hssfColor.getTriplet();
    fillColorString = "[" + rgb[0] + ", " + rgb[1] + ", "  + rgb[2] + "]";
   }
  }
  return fillColorString;
 }

 public static void main(String[] args) throws Exception {
  Workbook workbook = WorkbookFactory.create(new FileInputStream("workbook.xlsx"));
  //Workbook workbook = WorkbookFactory.create(new FileInputStream("workbook.xls"));
  Sheet sheet = workbook.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {

    System.out.println("Cell=" + cell.getAddress() + " " + cell.toString() + " " + getFillColorHex(cell));

   }
  }
 }

}
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.*;

class ReadExcelEmptyColoredCells {

 public static void main(String[] args) {
  try {

   //Workbook workbook = WorkbookFactory.create(new File("a.xls"));
   Workbook workbook = WorkbookFactory.create(new File("a.xlsx"));

   Sheet sheet = workbook.getSheetAt(0);

   for (Row row : sheet) {
    for (Cell cell : row) {
     if (! "".equals(String.valueOf(cell)))
      System.out.println(cell.getAddress() + ": " + String.valueOf(cell));
     CellStyle cellStyle = cell.getCellStyle();
     Color color = cellStyle.getFillForegroundColorColor();
     if (color != null) {
      if (color instanceof XSSFColor) {
       System.out.println(cell.getAddress() + ": " + ((XSSFColor)color).getARGBHex());
      } else if (color instanceof HSSFColor) {
       if (! (color instanceof HSSFColor.AUTOMATIC))
        System.out.println(cell.getAddress() + ": " + ((HSSFColor)color).getHexString());
      }
     }
    }
   }

   workbook.close();

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}
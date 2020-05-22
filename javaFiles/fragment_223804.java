import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.format.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;

class ReadExcelWithFormats {

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("workbook.xlsx");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   for (Row row : sheet) {

    for (Cell cell : row) {

     String formatstring = cell.getCellStyle().getDataFormatString();
     System.out.println(formatstring);

     switch (cell.getCellType()) {

      //...

      case Cell.CELL_TYPE_NUMERIC:
       double cellvalue = cell.getNumericCellValue();

       System.out.println(cellvalue);

       String formattedvalue = "";

       if ("general".equals(formatstring.toLowerCase())) {
        formattedvalue = new CellGeneralFormatter().format(cellvalue);
       } else {
        formattedvalue = new CellNumberFormatter(formatstring).format(cellvalue);
       }

       System.out.println(formattedvalue);

      break;

      //...

      default:
       System.out.println();
     }
    }
   }

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}
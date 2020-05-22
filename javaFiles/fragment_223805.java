import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.format.*;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;

import java.util.Date;

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

       String formattedvalue = "";
       String[] formatstringparts = formatstring.split(";");

       if (DateUtil.isCellDateFormatted(cell)) {

        Date date = cell.getDateCellValue();
        System.out.println(date);

        String dateformatstring = "";
        if (cell.getCellStyle().getDataFormat() == 14) { //default short date without explicit formatting
         dateformatstring = "yyyy-MM-dd"; //default date format for this
        } else if (cell.getCellStyle().getDataFormat() == 22) { //default short datetime without explicit formatting
         dateformatstring = "yyyy-MM-dd hh:mm"; //default datetime format for this
        } else { //other data formats with explicit formatting
         dateformatstring = formatstringparts[0];
        }
        formattedvalue = new CellDateFormatter(dateformatstring).format(date);
       } else {

        double cellvalue = cell.getNumericCellValue();
        System.out.println(cellvalue);

        switch (formatstringparts.length) {
         case 4:
         case 3:
          if (cellvalue > 0) {
           if ("general".equals(formatstringparts[0].toLowerCase())) {
            formattedvalue = new CellGeneralFormatter().format(cellvalue);
           } else {
            formattedvalue = new CellNumberFormatter(formatstringparts[0]).format(cellvalue);
           }
          }
          if (cellvalue < 0) {
           if ("general".equals(formatstringparts[1].toLowerCase())) {
            formattedvalue = new CellGeneralFormatter().format(cellvalue);
           } else {
            formattedvalue = new CellNumberFormatter(formatstringparts[1]).format(cellvalue);
           }
          }
          if (cellvalue == 0) {
           if ("general".equals(formatstringparts[2].toLowerCase())) {
            formattedvalue = new CellGeneralFormatter().format(cellvalue);
           } else {
            formattedvalue = new CellNumberFormatter(formatstringparts[2]).format(cellvalue);
           }
          }
         break;
         case 2:
          if (cellvalue >= 0) {
           if ("general".equals(formatstringparts[0].toLowerCase())) {
            formattedvalue = new CellGeneralFormatter().format(cellvalue);
           } else {
            formattedvalue = new CellNumberFormatter(formatstringparts[0]).format(cellvalue);
           }
          }
          if (cellvalue < 0) {
           if ("general".equals(formatstringparts[1].toLowerCase())) {
            formattedvalue = new CellGeneralFormatter().format(cellvalue);
           } else {
            formattedvalue = new CellNumberFormatter(formatstringparts[1]).format(cellvalue);
           }
          }
         break;
         default:
          if ("general".equals(formatstringparts[0].toLowerCase())) {
           formattedvalue = new CellGeneralFormatter().format(cellvalue);
          } else {
           formattedvalue = new CellNumberFormatter(formatstringparts[0]).format(cellvalue);
          }    
         }

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
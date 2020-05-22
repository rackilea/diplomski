import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;

class GetEmtyCellTest {

 public static void main(String[] args) {
  try {

   InputStream inp = new FileInputStream("workbook.xlsx");
   Workbook wb = WorkbookFactory.create(inp);

   Sheet sheet = wb.getSheetAt(0);

   Row row = sheet.getRow(0);

   System.out.println(row.getCell(0).getNumericCellValue()); //0.0
   System.out.println(row.getCell(0, Row.RETURN_BLANK_AS_NULL)); //null


   FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
   wb.write(fileOut);
   fileOut.flush();
   fileOut.close();

  } catch (InvalidFormatException ifex) {
  } catch (FileNotFoundException fnfex) {
  } catch (IOException ioex) {
  }
 }
}
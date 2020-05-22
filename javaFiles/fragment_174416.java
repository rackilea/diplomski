import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

class ExcelCopyRowFrom {

 public static void main(String[] args) throws Exception {

  XSSFWorkbook workbook = (XSSFWorkbook)WorkbookFactory.create(new FileInputStream("SAMPLE.xlsx"));
  XSSFSheet srcSheet = workbook.getSheetAt(0);
  XSSFRow srcRow = srcSheet.getRow(0);

  XSSFSheet destSheet = workbook.createSheet();
  //XSSFRow destRow = destSheet.createRow(0); //this fails because destination row number is the same as source row number

  XSSFRow destRow = destSheet.createRow(1); //this works 
  destRow.copyRowFrom(srcRow, new CellCopyPolicy());

  //workaround copy wrong first destination row to really needed destination row
  XSSFRow destRowNeeded = destSheet.createRow(0);
  destRowNeeded.copyRowFrom(destRow, new CellCopyPolicy());
  //the remove wrong first destination row
  destSheet.removeRow(destRow);

  FileOutputStream outputStream = new FileOutputStream("SAMPLENEW.xlsx");
  workbook.write(outputStream);
  outputStream.close();
  workbook.close();

 }
}
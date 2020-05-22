import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.streaming.*;

import java.lang.reflect.Field;

public class CreateExcelSXSSFWorkbookNumberAsText {

 public static void main(String[] args) throws Exception {

  SXSSFWorkbook workbook = new SXSSFWorkbook();

  DataFormat dataFormat = workbook.createDataFormat();

  CellStyle styleDef;
  styleDef = workbook.createCellStyle();
  styleDef.setDataFormat(dataFormat.getFormat("@"));
  //styleDef.setQuotePrefixed(true);

  SXSSFSheet sheet = workbook.createSheet();

  Field _sh = SXSSFSheet.class.getDeclaredField("_sh");
  _sh.setAccessible(true); 
  XSSFSheet xssfsheet = (XSSFSheet)_sh.get(sheet); 
  xssfsheet.addIgnoredErrors(new CellRangeAddress(0, 99, 0, 0), IgnoredErrorType.NUMBER_STORED_AS_TEXT);     

  for (int r = 0; r < 100; r++) {
   SXSSFRow row = sheet.createRow(r);
   SXSSFCell cell = row.createCell(0);
   String text = "" + new java.util.Random().nextInt();
   cell.setCellValue(text);
   cell.setCellStyle(styleDef);
  }

  workbook.write(new FileOutputStream("test.xlsx"));
  workbook.close();
  workbook.dispose();
 }
}
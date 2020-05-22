import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


class BuiltInFormats {

 public static void main(String[] args) {
  try {

    Workbook wb = new XSSFWorkbook();

    CellStyle builtInShortDate = wb.createCellStyle();
    builtInShortDate.setDataFormat((short)14);
    CellStyle builtInCurrency = wb.createCellStyle();
    builtInCurrency.setDataFormat((short)8);

    Sheet sheet = wb.createSheet();

    Row row = sheet.createRow(0);
    Cell cell = row.createCell(0);
    cell.setCellValue(new java.util.Date());
    cell.setCellStyle(builtInShortDate);

    row = sheet.createRow(1);
    cell = row.createCell(0);
    cell.setCellValue(1234.56);
    cell.setCellStyle(builtInCurrency);

    FileOutputStream os = new FileOutputStream("BuiltInFormats.xlsx");
    wb.write(os);
    os.close();

  } catch (IOException ioex) {
  }
 }
}
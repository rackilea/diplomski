import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelCellFillColor {

 public static void main(String[] args) throws Exception {
  Workbook workbook = new XSSFWorkbook();
  //Workbook workbook = new HSSFWorkbook();

  CellStyle cellStyle = workbook.createCellStyle();
  cellStyle.setAlignment(HorizontalAlignment.CENTER);
  cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

  cellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
  cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

  Sheet sheet = workbook.createSheet();
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0);
  cell.setCellValue("cell value");
  cell.setCellStyle(cellStyle);

  row.setHeightInPoints(50);
  sheet.setColumnWidth(0, 50 * 256);

  FileOutputStream out = null;
  if (workbook instanceof HSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCellFillColor.xls");
  } else if (workbook instanceof XSSFWorkbook) {
   out = new FileOutputStream("CreateExcelCellFillColor.xlsx");
  }
  workbook.write(out);
  out.close();
  workbook.close();
 }
}
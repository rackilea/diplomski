import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class CreateExcelXSSFProtectedSheet {

 public static void main(String[] args) throws Exception {

  Workbook workbook = new XSSFWorkbook();

  CreationHelper createHelper = workbook.getCreationHelper();

  CellStyle unlockedNumericStyle = workbook.createCellStyle();
  unlockedNumericStyle.setDataFormat(createHelper.createDataFormat().getFormat("$#,##0.00_);[Red]($#,##0.00)"));
  unlockedNumericStyle.setLocked(false);

  CellStyle dateStyle = workbook.createCellStyle();
  dateStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd/mm/yyyy"));

  Sheet sheet = workbook.createSheet();

  Row row = sheet.createRow(0);
  Cell cell = row.createCell(1);
  cell.setCellValue("some data");

  row = sheet.createRow(1);
  cell = row.createCell(1);
  cell.setCellValue(-123456789.0123456);
  cell.setCellStyle(unlockedNumericStyle);

  row = sheet.createRow(2);
  cell = row.createCell(1);
  cell.setCellValue(new java.util.Date());
  cell.setCellStyle(dateStyle);

  ((XSSFSheet)sheet).lockFormatColumns(false);

  sheet.protectSheet("passwordExcel"); 

  sheet.autoSizeColumn(1);

  workbook.write(new FileOutputStream("CreateExcelXSSFProtectedSheet.xlsx"));
  workbook.close();

 }

}
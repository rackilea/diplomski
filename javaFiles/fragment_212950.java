import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.File;

class ReadExcelFormulaEvaluatorExample {

 static Workbook workBook;
 static Sheet sheet;
 static FormulaEvaluator evaluator;
 static DataFormatter formatter;

 static {
  try {
   workBook = WorkbookFactory.create(new FileInputStream(new File("config.xlsx")));
   sheet = workBook.getSheetAt(0);
   evaluator = workBook.getCreationHelper().createFormulaEvaluator();
   formatter = new DataFormatter();
  } catch (Exception ex) {
   ex.printStackTrace();
  }
 }

 static CellValue getCellValue(int r, int c) throws Exception {
  Row row = sheet.getRow(r);
  Cell cell = row.getCell(c);
  System.err.println(cell.getCellFormula());
  CellValue cellValue = evaluator.evaluate(cell);
  return cellValue;
 }

 static String getCellContent(int r, int c) throws Exception {
  Row row = sheet.getRow(r);
  Cell cell = row.getCell(c);
  System.err.println(cell.getCellFormula());
  String cellContent = formatter.formatCellValue(cell, evaluator);

  return cellContent;
 }

 public static void main(String[] args) throws Exception {
  System.out.println("G2:");
  System.out.println(getCellValue(1, 6));

  System.out.println("Cell values:");
  for (int r = 1; r < 4; r++) {
   System.out.println(getCellValue(r, 5));
  }
  System.out.println("Cell contents:");

  for (int r = 1; r < 4; r++) {
   System.out.println(getCellContent(r, 5));
  }
  workBook.close();
 }
}
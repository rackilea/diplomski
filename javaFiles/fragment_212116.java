import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class CreateExcelEvaluateFormula {

 public static void main(String[] args) throws Exception {

  Workbook workbook  = new XSSFWorkbook();
  CreationHelper creationHelper = workbook.getCreationHelper();
  FormulaEvaluator formulaEvaluator = creationHelper.createFormulaEvaluator();

  Sheet sheet = workbook.createSheet();
  Row row = sheet.createRow(0);
  Cell cell = row.createCell(0); cell.setCellValue(21.7);
  cell = row.createCell(1); cell.setCellValue(20.0);

  cell = row.createCell(2); cell.setCellFormula("(A1-B1)/B1");
  formulaEvaluator.evaluateFormulaCell(cell); 
  double d = cell.getNumericCellValue();
System.out.println(d); //0.08499999999999996

  MyDataFormatter dataFormatter = new MyDataFormatter();

  String myFormat="0%";
  CellUtil.setCellStyleProperty(cell, CellUtil.DATA_FORMAT, creationHelper.createDataFormat().getFormat(myFormat));
  String val = dataFormatter.formatCellValue(cell, formulaEvaluator);
  System.out.println(val); //9%

  FileOutputStream out = new FileOutputStream("Excel.xlsx");
  workbook.write(out);
  out.close();
  workbook.close();

 }
}
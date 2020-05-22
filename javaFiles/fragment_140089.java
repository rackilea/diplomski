import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.formula.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;

import java.util.List;
import java.util.Arrays;

public class ExcelGetDataValidationFromDataValidationEvaluator {

 static DataValidation getDataValidationFromDataValidationEvaluator (Cell cell) {
  Sheet sheet = cell.getSheet(); 
  Workbook workbook = sheet.getWorkbook();
  WorkbookEvaluatorProvider workbookEvaluatorProvider =
   (WorkbookEvaluatorProvider)workbook.getCreationHelper().createFormulaEvaluator();
  DataValidationEvaluator dataValidationEvaluator = new DataValidationEvaluator(workbook, workbookEvaluatorProvider);
  DataValidation dataValidation = dataValidationEvaluator.getValidationForCell(new CellReference(cell));
  return dataValidation;
 }

 public static void main(String[] args) throws Exception {

  //String filePath = "ExcelWorkbook.xls";
  String filePath = "ExcelWorkbook.xlsx";

  Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
  Sheet sheet = workbook.getSheetAt(0);

  for (Row row : sheet) {
   for (Cell cell : row) {
    System.out.println(cell.getAddress());
    DataValidation dataValidation = getDataValidationFromDataValidationEvaluator(cell);
    if (dataValidation!=null) {
     DataValidationConstraint constraint = dataValidation.getValidationConstraint();
     System.out.println(dataValidation);
     System.out.println(constraint);
     if (constraint != null) {
      System.out.println("DataValidationConstraint.ValidationType: " + constraint.getValidationType());
       //https://poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/DataValidationConstraint.ValidationType.html
      System.out.println("Formula1: " + constraint.getFormula1());
      System.out.println("DataValidationConstraint.OperatorType: " + constraint.getOperator()); 
       //https://poi.apache.org/apidocs/dev/org/apache/poi/ss/usermodel/DataValidationConstraint.OperatorType.html
      System.out.println("Formula2: " + constraint.getFormula2());
      String[] listValues = constraint.getExplicitListValues();
      if (listValues != null) System.out.println("List values: " + Arrays.asList(listValues));
     }
    }
    System.out.println();
   }
  }

  workbook.close();
 }
}
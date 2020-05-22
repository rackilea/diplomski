import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;

import java.util.List;
import java.util.Arrays;

public class ExcelGetDataValidationConstraints {

 static DataValidationConstraint getDataValidationConstraint(Cell cell) {
  Sheet sheet = cell.getSheet(); 
  List<? extends DataValidation> dataValidations = sheet.getDataValidations(); // get sheet's data validations
  for (DataValidation dataValidation : dataValidations) {
   CellRangeAddressList addressList = dataValidation.getRegions(); // get Excel cell ranges the data validation applies to
   CellRangeAddress[] addresses = addressList.getCellRangeAddresses();
   for (CellRangeAddress address : addresses) {
    if (address.isInRange(cell)) { // if the cell is in that cell range
     DataValidationConstraint constraint = dataValidation.getValidationConstraint();
     return constraint; // return this
    }
   } 
  }
  return null; // per default return null
 }

 public static void main(String[] args) throws Exception {

  //String filePath = "ExcelWorkbook.xls";
  String filePath = "ExcelWorkbook.xlsx";

  Workbook workbook = WorkbookFactory.create(new FileInputStream(filePath));
  Sheet sheet = workbook.getSheetAt(0);

  for (Row row : sheet) {
   for (Cell cell : row) {
    DataValidationConstraint constraint = getDataValidationConstraint(cell);
    System.out.println(cell.getAddress());
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
    System.out.println();
   }
  }

  workbook.close();
 }
}
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.LocaleUtil;

import java.io.FileInputStream;

class ExcelDataformatterCustomized {

 public static void main(String[] args) throws Exception {

  Workbook wb  = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  LocaleUtil.setUserLocale(java.util.Locale.GERMANY);
  //LocaleUtil.setUserLocale(java.util.Locale.US);
  //LocaleUtil.setUserLocale(java.util.Locale.UK);

  DataFormatter df = new DataFormatter();
  FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

  if (LocaleUtil.getUserLocale().equals(java.util.Locale.GERMANY)) {
   df.addFormat("m/d/yy", new java.text.SimpleDateFormat("dd.MM.yyyy"));
  } else if (LocaleUtil.getUserLocale().equals(java.util.Locale.US)) {
   df.addFormat("m/d/yy", new java.text.SimpleDateFormat("M/d/yyyy"));
  } else if (LocaleUtil.getUserLocale().equals(java.util.Locale.UK)) {
   df.addFormat("m/d/yy", new java.text.SimpleDateFormat("dd/MM/yyyy"));
  }

  Sheet sheet = wb.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {

     String value = df.formatCellValue(cell, evaluator);
     System.out.println(value);

   }
  }
  wb.close();
 }
}
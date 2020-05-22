import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;

import java.io.FileInputStream;

import java.lang.reflect.Method;

class ExcelDataformatterExample {

 public static void main(String[] args) throws Exception {

  Workbook wb  = WorkbookFactory.create(new FileInputStream("ExcelExample.xlsx"));

  DataFormatter df = new DataFormatter();
  MyDataFormatter mydf = new MyDataFormatter();

  Sheet sheet = wb.getSheetAt(0);
  for (Row row : sheet) {
   for (Cell cell : row) {
    if (cell.getCellTypeEnum() == CellType.NUMERIC) {
     CellReference cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
     System.out.println("Cell " + cellRef.formatAsString());

     System.out.print("Excel's data format string: ");
     String formatStr = cell.getCellStyle().getDataFormatString();
     System.out.println(formatStr);

     System.out.print("Value using poi's data formatter: ");
     Method cleanFormatForNumber = DataFormatter.class.getDeclaredMethod("cleanFormatForNumber", String.class); 
     cleanFormatForNumber.setAccessible(true); 
     String cleanFormatStr = (String)cleanFormatForNumber.invoke(df, formatStr);
     System.out.print("using poi's cleanFormatStr: ");
     System.out.print(cleanFormatStr + " result: ");
     String value = df.formatCellValue(cell);
     System.out.println(value);

     System.out.print("Value using my data formatter: ");
     cleanFormatForNumber = MyDataFormatter.class.getDeclaredMethod("cleanFormatForNumber", String.class); 
     cleanFormatForNumber.setAccessible(true); 
     cleanFormatStr = (String)cleanFormatForNumber.invoke(mydf, formatStr);
     System.out.print("using my cleanFormatStr: ");
     System.out.print(cleanFormatStr + " result: ");
     value = mydf.formatCellValue(cell);
     System.out.println(value);

    }
   }
  }
  wb.close();

 }

}
import java.io.File;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcelCreate {

  public static void main(String[] args) {
    try {

         WritableWorkbook workbook =
         Workbook.createWorkbook(new File("output.xls"));
         WritableSheet sheet = workbook.createSheet("Page1", 0);

         String Label[] = new String[4];
         Label[0] = "Emp ID";
         Label[1] = "Name";
         Label[2] = "Department";
         Label[3] = "Designation";

         WritableCellFormat cellFormat = new WritableCellFormat();
         WritableFont font = new WritableFont(WritableFont.ARIAL);
         font.setStruckout(true);
         cellFormat.setFont(font);

         for (int i = 0; i < Label.length; i++) {
             Label label = new Label(i, 0, Label[i]);
             sheet.addCell(label);
             WritableCell cell = sheet.getWritableCell(i, 0);
             cell.setCellFormat(cellFormat);
         }

         workbook.write();
         workbook.close();

    } catch (Exception e) {
        /* Write your logic to handle exception. 
         */
    }
  }
}
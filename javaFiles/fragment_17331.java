import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

class CreateExcelWithComments {

 public static void main(String[] args) throws Exception {

    String type = "HSSF";
    //String type = "XSSF";

    Workbook wb = ("HSSF".equals(type))?new HSSFWorkbook():new XSSFWorkbook();

    CreationHelper factory = wb.getCreationHelper();

    Sheet sheet = wb.createSheet();

    Row row   = sheet.createRow(0);
    Cell cell = row.createCell(0); // cell A1
    cell.setCellValue("A1");

    Drawing drawing = sheet.createDrawingPatriarch();

    // When the comment box is visible, have it show in a 1x3 space
    ClientAnchor anchor = factory.createClientAnchor();
    anchor.setCol1(cell.getColumnIndex()+1);                           // starts at column A + 1 = B
    anchor.setDx1(("HSSF".equals(type))?10*15:10*Units.EMU_PER_PIXEL); // plus 10 px     
    anchor.setCol2(cell.getColumnIndex()+2);                           // ends at column A + 2 = C
    anchor.setDx2(("HSSF".equals(type))?10*15:10*Units.EMU_PER_PIXEL); // plus 10 px    

    anchor.setRow1(row.getRowNum());                                   // starts at row 1
    anchor.setDy1(("HSSF".equals(type))?10*15:10*Units.EMU_PER_PIXEL); // plus 10 px
    anchor.setRow2(row.getRowNum()+3);                                 // ends at row 4
    anchor.setDy2(("HSSF".equals(type))?10*15:10*Units.EMU_PER_PIXEL); // plus 10 px


    // Create the comment and set the text+author
    Comment comment = drawing.createCellComment(anchor);
    RichTextString str = factory.createRichTextString("Hello, World!");
    comment.setString(str);
    comment.setAuthor("Apache POI");

    // Assign the comment to the cell
    cell.setCellComment(comment);

    String fname = ("HSSF".equals(type))?"./comment-xssf.xls":"./comment-xssf.xlsx";
    try (OutputStream out = new FileOutputStream(fname)) {
        wb.write(out);
    }

    wb.close();

 }
}
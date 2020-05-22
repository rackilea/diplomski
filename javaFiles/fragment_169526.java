import java.io.FileOutputStream;
import org.apache.poi.xwpf.usermodel.*;

public class CreateWordTableVerticalAlign {

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The table:");

  //create the table
  XWPFTable table = document.createTable(3,3);
  table.setWidth("100%");
  for (int r = 0; r < 3; r++) {
   XWPFTableRow row = table.getRow(r);

   row.setHeight(1440/2); // 1/2inch; 1440Twip = 1440/20 == 72pt = 1inch 

   for (int c = 0; c < 3; c++) {
    XWPFTableCell cell = row.getCell(c);
    cell.setText("row " + r + ", col " + c);

    // get first paragraph in cell - this contains the content set above by cell.setText
    XWPFParagraph firstParagraphInCell = cell.getParagraphArray(0);
    // set spacing after to 0 (defaults to 10pt)
    firstParagraphInCell.setSpacingAfter(0);

    if (r == 0) {
     // default vertical align
    } else if (r == 1) {
     cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
    } else if (r == 2) {
     cell.setVerticalAlignment(XWPFTableCell.XWPFVertAlign.BOTTOM);
    }
   }
  }

  FileOutputStream out = new FileOutputStream("CreateWordTableVerticalAlign.docx"); 
  document.write(out);
  out.close();
  document.close();
 }
}
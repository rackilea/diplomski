import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import org.apache.xmlbeans.XmlCursor;
import java.math.BigInteger;


public class WordInsertTableInBody {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordTableExample.docx"));
  XmlCursor cursor = null;
  XWPFParagraph paragraph = null; 
  XWPFRun run = null; 

  boolean foundTablePosition = false;
  boolean thereWasParagraphAfter = false;
  for (IBodyElement element : document.getBodyElements()) {
   if (element instanceof XWPFParagraph) {
    paragraph = (XWPFParagraph) element;
    StringBuilder sb = new StringBuilder();
    for (XWPFRun irun : paragraph.getRuns()) {
     sb.append(irun.getText(0));
System.out.println(sb);
     if (sb.toString().contains("Text after which table should be created")) {
      cursor= paragraph.getCTP().newCursor();
      thereWasParagraphAfter = cursor.toNextSibling(); // move cursor to next paragraph 
       //because the table shall be **after** that paragraph
       //thereWasParagraphAfter is true if there is a next paragraph, else false
      foundTablePosition = true;
     }
    }
   }
   if (foundTablePosition) break;
  } 

  if (cursor != null) {
   if (thereWasParagraphAfter) {
    paragraph = document.insertNewParagraph(cursor);
   } else {
    paragraph = document.createParagraph();
   }
   cursor = paragraph.getCTP().newCursor();
   XWPFTable table = document.insertNewTbl(cursor);
   XWPFTableRow row = table.getRow(0); if (row == null) row = table.createRow();
   int twipsPerInch =  1440;
   table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(1*1440));
   for (int col = 1 ; col < 4; col++) {
    table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(1*1440));
   }
   for (int i = 0; i < 4; i++) {
    XWPFTableCell cell = row.getCell(i); if (cell == null) cell = row.createCell();
    CTTblWidth tblWidth = cell.getCTTc().addNewTcPr().addNewTcW();
    tblWidth.setW(BigInteger.valueOf(1 * twipsPerInch));
    tblWidth.setType(STTblWidth.DXA);
    paragraph = cell.getParagraphs().get(0);
    run = paragraph.createRun();
    run.setText("Table Cell " + i);
   }
  }

  document.write(new FileOutputStream("WordTableExampleNew.docx"));
  document.close();
 }
}
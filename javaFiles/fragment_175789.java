import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

import org.apache.xmlbeans.XmlCursor;
import java.math.BigInteger;

public class CreateWordHeaderFooterTable {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  // the body content
  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The Body:");

  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum.... page 1");

  paragraph = document.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum.... page 2");

  paragraph = document.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum.... page 3"); 

  // create header start
  XWPFHeader header = document.createHeader(HeaderFooterType.DEFAULT);

  paragraph = header.getParagraphArray(0);
  if (paragraph == null) paragraph = header.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.LEFT);

  run = paragraph.createRun();  
  run.setText("The Header");

  // create footer start
  XWPFFooter footer = document.createFooter(HeaderFooterType.DEFAULT);

  // create table in footer
  paragraph = footer.getParagraphArray(0);
  if (paragraph == null) paragraph = footer.createParagraph();
  XmlCursor cursor = paragraph.getCTP().newCursor();
  XWPFTable table = footer.insertNewTbl(cursor);
  XWPFTableRow row = table.getRow(0); if (row == null) row = table.createRow();
  int twipsPerInch =  1440;
  table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(7 * twipsPerInch));
  for (int i = 0; i < 3; i++) {
   XWPFTableCell cell = row.getCell(i); if (cell == null) cell = row.createCell();
   CTTblWidth tblWidth = cell.getCTTc().addNewTcPr().addNewTcW();
   tblWidth.setW(BigInteger.valueOf(((i==1)?3:2) * twipsPerInch));
   tblWidth.setType(STTblWidth.DXA);
   paragraph = cell.getParagraphs().get(0);
   run = paragraph.createRun();
   if (i == 0) {
    paragraph.setAlignment(ParagraphAlignment.LEFT);
    run.setText("Left footer text");
   } else if (i == 1) {
    paragraph.setAlignment(ParagraphAlignment.CENTER);
    run.setText("Page ");
    paragraph.getCTP().addNewFldSimple().setInstr("PAGE \\* MERGEFORMAT");
    run = paragraph.createRun();  
    run.setText(" of ");
    paragraph.getCTP().addNewFldSimple().setInstr("NUMPAGES \\* MERGEFORMAT");
   } else if (i == 2) {
    paragraph.setAlignment(ParagraphAlignment.RIGHT);
    run.setText("Right footer text");
   }
  }

  FileOutputStream out = new FileOutputStream("CreateWordHeaderFooterTable.docx");
  document.write(out);
  out.close();
  document.close();

 }
}
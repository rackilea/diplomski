import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordInsertTableRows {

 public static void main(String[] args) throws Exception {

  XWPFDocument doc = new XWPFDocument(new FileInputStream("WordTableExample.docx"));
  XWPFTable table = doc.getTableArray(0);
  XWPFTableRow row;
  XWPFParagraph paragraph;
  XWPFRun run;

  String itemNames[] = {"Item 1", "Item Name 2", "Item 3"};

  for(int i=0; i<itemNames.length; i++) {
   row = table.getRow(1+i); //getRow(1) represents second row of the table
   if (row == null) row = table.createRow(); //if there is not a row already, then create one
   //printing sr. no
   paragraph = row.getCell(0).getParagraphArray(0);
   if (paragraph == null) paragraph = row.getCell(0).addParagraph();
   paragraph.setAlignment(ParagraphAlignment.CENTER);
   //paragraph.setVerticalAlignment(TextAlignment.CENTER); //this sets valign for the paragraph
   row.getCell(0).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER); //I suspect you wants set valign for the cell
   run = paragraph.createRun();
   run.setText(""+(i+1));

   //printing item names
   paragraph = row.getCell(1).getParagraphArray(0);
   if (paragraph == null) paragraph = row.getCell(1).addParagraph();
   paragraph.setAlignment(ParagraphAlignment.CENTER);
   //paragraph.setVerticalAlignment(TextAlignment.CENTER);
   row.getCell(1).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
   run = paragraph.createRun();
   run.setText(itemNames[i]);

   //printing qty
   paragraph = row.getCell(2).getParagraphArray(0);
   if (paragraph == null) paragraph = row.getCell(2).addParagraph();
   //paragraph.setVerticalAlignment(TextAlignment.CENTER);
   row.getCell(2).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
   run = paragraph.createRun();
   run.setText(""+(1 + (i*10)));
  }

  doc.write(new FileOutputStream("WordTableExampleNew.docx"));

  doc.close();
 }
}
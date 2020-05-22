import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSimpleField;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;

public class CreateWordTableSumAbove {

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run=paragraph.createRun();  
  run.setText("The table:");

  //create the table
  XWPFTable table = document.createTable(4,3);
  table.setWidth("100%");
  for (int row = 0; row < 3; row++) {
   for (int col = 0; col < 3; col++) {
    if (col < 2) table.getRow(row).getCell(col).setText("row " + row + ", col " + col);
    else table.getRow(row).getCell(col).setText("" + ((row + 1) * 1234));
   }
  }

  //set Sum row
  table.getRow(3).getCell(0).setText("Sum:");

  //get paragraph from cell where the sum field shall be contained
  XWPFParagraph paragraphInCell = null;
  if (table.getRow(3).getCell(2).getParagraphs().size() == 0) paragraphInCell = table.getRow(3).getCell(2).addParagraph();
  else paragraphInCell = table.getRow(3).getCell(2).getParagraphs().get(0);

  //set sum field in
  CTSimpleField sumAbove = paragraphInCell.getCTP().addNewFldSimple();
  sumAbove.setInstr("=SUM(ABOVE)");
  //set sum field dirty, so it must be calculated while opening the document
  sumAbove.setDirty(STOnOff.TRUE);

  paragraph = document.createParagraph();

  FileOutputStream out = new FileOutputStream("create_table.docx"); 
  document.write(out);
  out.close();
  document.close();
 }
}
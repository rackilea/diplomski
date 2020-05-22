import java.io.FileOutputStream;
import java.io.FileInputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordTextAfterTable {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("WordTextAfterTable.docx"));

  XWPFTable table = document.getTables().get(9);

  org.apache.xmlbeans.XmlCursor cursor = table.getCTTbl().newCursor();
  cursor.toEndToken(); //now we are at end of the CTTbl
  //there always must be a next start token after the table. Either a p or at least sectPr.
  while(cursor.toNextToken() != org.apache.xmlbeans.XmlCursor.TokenType.START); //we loop over the tokens until next TokenType.START
  //now we are at next TokenType.START and insert the new table
  //note: This is immediately after the table. So both tables touch each other.
  table = document.insertNewTbl(cursor);     
  table.getRow(0).getCell(0).addParagraph().createRun().setText("Name");
  table.createRow().getCell(0).addParagraph().createRun().setText("Version");
  table.createRow().getCell(0).addParagraph().createRun().setText("Description");
  table.createRow().getCell(0).addParagraph().createRun().setText("Comments");
  table.createRow().getCell(0).addParagraph().createRun().addCarriageReturn();        
  //...
System.out.println(cursor.isEnd()); //cursor is now at the end of the new table
  //there always must be a next start token after the table. Either a p or at least sectPr.
  while(cursor.toNextToken() != org.apache.xmlbeans.XmlCursor.TokenType.START); //we loop over the tokens until next TokenType.START
  XWPFParagraph newParagraph = document.insertNewParagraph(cursor);
  XWPFRun run = newParagraph.createRun(); 
  run.setText("text after table");

  document.write(new FileOutputStream("WordTextAfterTableNew.docx"));
  document.close();
 }
}
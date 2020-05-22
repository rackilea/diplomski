import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBookmark;

import java.math.BigInteger;

public class CreateWordBookmark {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();

  //bookmark before the run
  CTBookmark bookmark = paragraph.getCTP().addNewBookmarkStart();
  bookmark.setName("before_testing_string");
  bookmark.setId(BigInteger.valueOf(0));
  paragraph.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(0));

  //bookmark the run
  bookmark = paragraph.getCTP().addNewBookmarkStart();
  bookmark.setName("testing_string");
  bookmark.setId(BigInteger.valueOf(1));

  XWPFRun run = paragraph.createRun();
  run.setText("testing string ");

  paragraph.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(1));

  //bookmark after the run
  bookmark = paragraph.getCTP().addNewBookmarkStart();
  bookmark.setName("after_testing_string");
  bookmark.setId(BigInteger.valueOf(2));
  paragraph.getCTP().addNewBookmarkEnd().setId(BigInteger.valueOf(2));

  document.write(new FileOutputStream("CreateWordBookmark.docx"));
  document.close();

 }
}
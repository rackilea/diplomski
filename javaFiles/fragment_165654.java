import java.io.*;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.wp.usermodel.HeaderFooterType;

import java.lang.reflect.Field;

public class CreateWordHeaderFooterType {

 public static void main(String[] args) throws Exception {

  XWPFDocument document= new XWPFDocument();

  XWPFParagraph paragraph;
  XWPFRun run;  

  // the body content
  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.setText("Lorem ipsum.... page 1");

  paragraph = document.createParagraph();
  run=paragraph.createRun();
  run.addBreak(BreakType.PAGE); 
  run.setText("Lorem ipsum.... page 2");

  // create even header
  document
    .createHeader(HeaderFooterType.EVEN)
    .createParagraph()
    .createRun()
    .setText("even");


  // set evenAndOddHeaders in settings.xml
  Field _settings = XWPFDocument.class.getDeclaredField("settings");
  _settings.setAccessible(true); 
  XWPFSettings xwpfsettings = (XWPFSettings)_settings.get(document); 
  Field _ctSettings = XWPFSettings.class.getDeclaredField("ctSettings");
  _ctSettings.setAccessible(true); 
  org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings ctsettings = 
   (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings)_ctSettings.get(xwpfsettings); 

  ctsettings.addNewEvenAndOddHeaders();


  document.write(new FileOutputStream("CreateWordHeaderFooterType.docx"));
  document.close();

 }
}
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileOutputStream;

public class CreateWordComboboxField {

 public static void main(String[] args) throws Exception {

/*
needs the full ooxml-schemas-1.3.jar as mentioned in https://poi.apache.org/faq.html#faq-N10025
*/

  XWPFDocument document = new XWPFDocument();
  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();

  run.setText("Combobox field: ");

  org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtRun ctSdtRun = paragraph.getCTP().addNewSdt();
  org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtComboBox ctSdtComboBox = ctSdtRun.addNewSdtPr().addNewComboBox();
  org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSdtListItem ctSdtListItem = ctSdtComboBox.addNewListItem();
  ctSdtListItem.setDisplayText("please select an option");
  ctSdtListItem.setValue("please select an option");
  ctSdtListItem = ctSdtComboBox.addNewListItem();
  ctSdtListItem.setDisplayText("one");
  ctSdtListItem.setValue("one");    
  ctSdtListItem = ctSdtComboBox.addNewListItem();
  ctSdtListItem.setDisplayText("two");
  ctSdtListItem.setValue("two");    
  ctSdtListItem = ctSdtComboBox.addNewListItem();
  ctSdtListItem.setDisplayText("three");
  ctSdtListItem.setValue("three");    

  ctSdtRun.addNewSdtContent().addNewR().addNewT().setStringValue("please select an option");

  run = paragraph.createRun();
  run.setText(" after combobox field...");

  paragraph = document.createParagraph();

  document.write(new FileOutputStream("CreateWordComboboxField.docx"));
  document.close();
 }
}
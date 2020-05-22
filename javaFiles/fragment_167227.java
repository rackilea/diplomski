import java.io.*;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import org.apache.xmlbeans.*;
import javax.xml.namespace.QName;

public class WordFillCheckBox {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("source.docx"));

  for (XWPFParagraph paragraph : document.getParagraphs()) { //go through all paragraphs
   for (CTSdtRun sdtRun : paragraph.getCTP().getSdtList()) {
    if (W14Checkbox.isW14Checkbox(sdtRun)) {
     W14Checkbox w14Checkbox = new W14Checkbox(sdtRun);
     System.out.println(w14Checkbox.getChecked());
     if (w14Checkbox.getChecked()) w14Checkbox.setChecked(false); else w14Checkbox.setChecked(true);
     System.out.println(w14Checkbox.getChecked());
    }
   }
  }

  FileOutputStream out = new FileOutputStream("result.docx");
  document.write(out);
  out.close();
  document.close();

 }

 static class W14Checkbox {
  CTSdtRun sdtRun = null;
  CTSdtContentRun sdtContentRun = null;
  XmlObject w14CheckboxChecked = null;

  W14Checkbox(CTSdtRun sdtRun) {
   this.sdtRun = sdtRun;
   this.sdtContentRun = sdtRun.getSdtContent();
   String declareNameSpaces = "declare namespace w14='http://schemas.microsoft.com/office/word/2010/wordml'";
   XmlObject[] selectedObjects = sdtRun.getSdtPr().selectPath(declareNameSpaces + ".//w14:checkbox/w14:checked");
   if (selectedObjects.length > 0) {  
    this.w14CheckboxChecked  = selectedObjects[0];
   }
  }
  CTSdtContentRun getContent() {
   return this.sdtContentRun;
  }
  XmlObject getW14CheckboxChecked() {
   return this.w14CheckboxChecked;
  }
  boolean getChecked() {
   XmlCursor cursor = this.w14CheckboxChecked.newCursor();
   String val = cursor.getAttributeText(new QName("http://schemas.microsoft.com/office/word/2010/wordml", "val", "w14"));
   return "1".equals(val) || "true".equals(val);
  }
  void setChecked(boolean checked) {
   XmlCursor cursor = this.w14CheckboxChecked.newCursor();
   String val = (checked)?"1":"0";
   cursor.setAttributeText(new QName("http://schemas.microsoft.com/office/word/2010/wordml", "val", "w14"), val);
   cursor.dispose();
   CTText t = this.sdtContentRun.getRArray(0).getTArray(0);
   String content = (checked)?"\u2612":"\u2610";
   t.setStringValue(content);
  }

  static boolean isW14Checkbox(CTSdtRun sdtRun) {
   CTSdtPr sdtPr = sdtRun.getSdtPr();
   String declareNameSpaces = "declare namespace w14='http://schemas.microsoft.com/office/word/2010/wordml'";
   XmlObject[] selectedObjects = sdtPr.selectPath(declareNameSpaces + ".//w14:checkbox");
   if (selectedObjects.length > 0) return true;  
   return false;
  }
 }
}
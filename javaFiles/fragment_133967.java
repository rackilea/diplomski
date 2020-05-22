import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHyperlink;

public class CreateWordStyledHyperlinkRunFromTemplate {

 static XWPFHyperlinkRun createHyperlinkRun(XWPFParagraph paragraph, String uri) throws Exception {
  String rId = paragraph.getPart().getPackagePart().addExternalRelationship(
    uri, 
    XWPFRelation.HYPERLINK.getRelation()
   ).getId();

  CTHyperlink cthyperLink=paragraph.getCTP().addNewHyperlink();
  cthyperLink.setId(rId);
  cthyperLink.addNewR();

  return new XWPFHyperlinkRun(
    cthyperLink,
    cthyperLink.getRArray(0),
    paragraph
   );
 }

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("Template.docx"));

  XWPFParagraph paragraph = document.createParagraph();
  XWPFRun run = paragraph.createRun();
  run.setText("This is a text paragraph having a link to Google ");

  XWPFHyperlinkRun hyperlinkrun = createHyperlinkRun(paragraph, "https://www.google.de");
  hyperlinkrun.setText("https://www.google.de");
  XWPFStyles styles = document.getStyles();
  if (styles.styleExist("Hyperlink")) {
   System.out.println("Style Hyperlink exists."); //Template must contain named style "Hyperlink" already
   hyperlinkrun.setStyle("Hyperlink");
  } else {
   hyperlinkrun.setColor("0000FF");
   hyperlinkrun.setUnderline(UnderlinePatterns.SINGLE);
  }

  run = paragraph.createRun();
  run.setText(" in it.");

  FileOutputStream out = new FileOutputStream("CreateWordStyledHyperlinkRunFromTemplate.docx");
  document.write(out);
  out.close();
  document.close();

 }
}
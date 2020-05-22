import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.apache.poi.POIXMLDocumentPart;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSettings;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STSectionMark;

import java.lang.reflect.Field;

import java.math.BigInteger;

public class CreateWordAutoHyphenation {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  POIXMLDocumentPart part = null;
  for (int i = 0; i < document.getRelations().size(); i++) {
   part = document.getRelations().get(i);
   if (part instanceof XWPFSettings) break;
  }
  if (part instanceof XWPFSettings) {
   XWPFSettings settings = (XWPFSettings)part;
   Field _ctSettings = XWPFSettings.class.getDeclaredField("ctSettings"); 
   _ctSettings.setAccessible(true); 
   CTSettings ctSettings = (CTSettings)_ctSettings.get(settings);
   ctSettings.addNewAutoHyphenation();
  }

  String testtext = "This text tests whether automatic hyphenation opportunities are set on for this document and not are suppressed for this paragraph. Since in Word Office OpenXML the automatic hyphenation settings are set for the whole document and may be suppressed for single paragraphs.";

  XWPFParagraph paragraph = document.createParagraph();
  paragraph.setAlignment(ParagraphAlignment.BOTH);
  XWPFRun run = paragraph.createRun();
  run.setFontSize(18);
  run.getCTR().getRPr().addNewLang().setVal("en-US");
  run.setText(testtext);

  paragraph = document.createParagraph();
  run=paragraph.createRun();  
  run.addBreak(BreakType.COLUMN);

  paragraph.setAlignment(ParagraphAlignment.BOTH);
  paragraph.getCTP().addNewPPr().addNewSuppressAutoHyphens();
  run = paragraph.createRun();
  run.setFontSize(18);
  run.getCTR().getRPr().addNewLang().setVal("en-US");
  run.setText(testtext);

  document.getDocument().getBody().addNewSectPr().addNewType().setVal(STSectionMark.CONTINUOUS);
  document.getDocument().getBody().getSectPr().addNewCols().setNum(BigInteger.valueOf(2));

  document.write(new FileOutputStream("CreateWordAutoHyphenation.docx"));
  document.close();

 }
}
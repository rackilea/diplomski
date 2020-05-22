import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;

import java.math.BigInteger;

public class CreateWordPageMargins {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument();

  XWPFParagraph paragraph = document.createParagraph();

  XWPFRun run = paragraph.createRun();  
  run.setText("Text");

  CTSectPr sectPr = document.getDocument().getBody().getSectPr();
  if (sectPr == null) sectPr = document.getDocument().getBody().addNewSectPr();
  CTPageMar pageMar = sectPr.getPgMar();
  if (pageMar == null) pageMar = sectPr.addNewPgMar();
  pageMar.setLeft(BigInteger.valueOf(720)); //720 TWentieths of an Inch Point (Twips) = 720/20 = 36 pt = 36/72 = 0.5"
  pageMar.setRight(BigInteger.valueOf(720));
  pageMar.setTop(BigInteger.valueOf(720));
  pageMar.setBottom(BigInteger.valueOf(720));
  pageMar.setFooter(BigInteger.valueOf(720));
  pageMar.setHeader(BigInteger.valueOf(720));
  pageMar.setGutter(BigInteger.valueOf(0));

  FileOutputStream out = new FileOutputStream("CreateWordPageMargins.docx");
  document.write(out);
  out.close();
  document.close();

 }
}
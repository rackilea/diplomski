import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;

public class ReadWordAllHeaderFooters {

 static void getAllHeaderFooterFromPolicy(XWPFHeaderFooterPolicy headerFooterPolicy) {
  XWPFHeader header;
  XWPFFooter footer;
  header = headerFooterPolicy.getDefaultHeader();
  if (header != null) System.out.println("DefaultHeader: " + header.getText());
  header = headerFooterPolicy.getFirstPageHeader();
  if (header != null) System.out.println("FirstPageHeader: " + header.getText());
  header = headerFooterPolicy.getEvenPageHeader();
  if (header != null) System.out.println("EvenPageHeader: " + header.getText());
  header = headerFooterPolicy.getOddPageHeader();
  if (header != null) System.out.println("OddPageHeader: " + header.getText());

  footer = headerFooterPolicy.getDefaultFooter();
  if (footer != null) System.out.println("DefaultFooter: " + footer.getText());
  footer = headerFooterPolicy.getFirstPageFooter();
  if (footer != null) System.out.println("FirstPageFooter: " + footer.getText());
  footer = headerFooterPolicy.getEvenPageFooter();
  if (footer != null) System.out.println("EvenPageFooter: " + footer.getText());
  footer = headerFooterPolicy.getOddPageFooter();
  if (footer != null) System.out.println("OddPageFooter: " + footer.getText());
 }

 public static void main(String[] args) throws Exception {
  XWPFDocument document = new XWPFDocument(new FileInputStream("MultipleHeaderFooters.docx"));
  XWPFHeaderFooterPolicy headerFooterPolicy;

  //are there paragraphs to start sections?
  int section = 1;
  for (XWPFParagraph paragraph : document.getParagraphs()) {
   if (paragraph.getCTP().isSetPPr()) { //paragraph has paragraph properties set
    if (paragraph.getCTP().getPPr().isSetSectPr()) { //paragraph property has section properties set
     //headers and footers in paragraphs section properties:
     headerFooterPolicy = new XWPFHeaderFooterPolicy(document, paragraph.getCTP().getPPr().getSectPr());
     System.out.println("headers and footers in section properties of section " + section++ + ":");
     getAllHeaderFooterFromPolicy(headerFooterPolicy);
    }
   }
  }

  //headers and footers in documents body = headers and footers of last section:
  headerFooterPolicy = new XWPFHeaderFooterPolicy(document);
  System.out.println("headers and footers in documents body = headers and footers of last section " + section + ":");
  getAllHeaderFooterFromPolicy(headerFooterPolicy);

 }
}
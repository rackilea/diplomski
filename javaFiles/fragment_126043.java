import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordReadDOTXSaveDOCX {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("StudentReport.dotx"));
  document.getPackage().replaceContentType(
   "application/vnd.openxmlformats-officedocument.wordprocessingml.template.main+xml",
   "application/vnd.openxmlformats-officedocument.wordprocessingml.document.main+xml");

  FileOutputStream out = new FileOutputStream("TheDocumentFromDOTXTemplate.docx");
  document.write(out);
  out.close();
  document.close();
 }
}
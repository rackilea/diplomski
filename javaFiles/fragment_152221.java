import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordRemoveEmptyParagraphs {

 public static void main(String[] args) throws Exception {

  XWPFDocument document = new XWPFDocument(new FileInputStream("./WordTables.docx"));

  int thisBodyElementPos = 0;
  int nextBodyElementPos = 1;
  IBodyElement thisBodyElement = null;
  IBodyElement nextBodyElement = null;
  if (document.getBodyElements().size() > 1) { // document must have at least two body elements
   do {
    thisBodyElement = document.getBodyElements().get(thisBodyElementPos);
    nextBodyElement = document.getBodyElements().get(nextBodyElementPos);
    if (thisBodyElement instanceof XWPFTable && nextBodyElement instanceof XWPFParagraph) {
     XWPFParagraph paragraph = (XWPFParagraph)nextBodyElement;
     if (paragraph.getRuns().size() == 0) { // if paragraph does not have any text runs in it
      document.removeBodyElement(nextBodyElementPos);
     }
    }
    thisBodyElementPos++;
    nextBodyElementPos = thisBodyElementPos + 1;
   } while (nextBodyElementPos < document.getBodyElements().size());
  }

  FileOutputStream out = new FileOutputStream("./WordTablesChanged.docx");
  document.write(out);
  out.close();
  document.close();
 }
}
public interface DocumentSaveHandler {
   void save(Document doc);
}

public class PdfSaveHandler {
 void save(Document doc) { 
   // save the document in the pdf format
 }
}

public class TextSaveHandler {
 void save(Document doc) { 
   // save the document in the textual format
 }
}
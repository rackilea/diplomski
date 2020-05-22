import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

    public class AnchorExample {

      public static void main(String[] args) {

        Document document = new Document();

        try {
          PdfWriter.getInstance(document,
                new FileOutputStream("Anchor.pdf"));

          document.open();

          Paragraph paragraph = new Paragraph();
          paragraph.add(new Phrase("You can find the IText tutorial at "));


          Anchor anchor = new Anchor(
              "http://tutorials.jenkov.com/java-itext/index.html");
          anchor.setReference(
              "http://tutorials.jenkov.com/java-itext/index.html");

          paragraph.add(anchor);

          document.add(paragraph);

          document.close();

        } catch (DocumentException e) {
          e.printStackTrace();
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        }

      }
    }
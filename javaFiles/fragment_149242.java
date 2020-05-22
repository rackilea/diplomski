import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;

public class App {

    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Document document = new Document(PageSize.A6, 20, 20, 20, 20);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("/tmp/out.pdf"));
        writer.setPageEvent(new PdfListener());
        document.open();
        for (int i = 0; i < 10; i++) {
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Phrase("The chapter "+i));
            Chapter chapter = new Chapter(paragraph, 1);
            Section section1 = chapter.addSection("The section "+i+".1", 2);
            Section section2 = chapter.addSection("The section "+i+".2", 2);
            document.add(chapter);
            document.add(section1);
            document.add(section2);
        }
        document.close();
    }

    public static class PdfListener implements PdfPageEvent {

        public void onChapter(PdfWriter writer, Document dcmnt, float f, Paragraph prgrph) {
            if( f < 50.0f ){
                dcmnt.newPage();
            }
        }
        public void onChapterEnd(PdfWriter writer, Document dcmnt, float f) {}
        public void onSection(PdfWriter writer, Document dcmnt, float f, int i, Paragraph prgrph) {
            if( f < 50.0f ){
                dcmnt.newPage();
            }
        }
        public void onSectionEnd(PdfWriter writer, Document dcmnt, float f) {}
        public void onOpenDocument(PdfWriter writer, Document dcmnt) {}
        public void onStartPage(PdfWriter writer, Document dcmnt) {}
        public void onEndPage(PdfWriter writer, Document dcmnt) {}
        public void onCloseDocument(PdfWriter writer, Document dcmnt) {}
        public void onParagraph(PdfWriter writer, Document dcmnt, float f) {}
        public void onParagraphEnd(PdfWriter writer, Document dcmnt, float f) {}        
        public void onGenericTag(PdfWriter writer, Document dcmnt, Rectangle rctngl, String string) {}

    }
}
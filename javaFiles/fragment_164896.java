// iText imports
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;
public class HindiText {

    @Test
    public void go() throws Exception {
        try (PdfDocument doc = new PdfDocument(new PdfReader("input.pdf"))) {
            try (OutputStream os = new FileOutputStream("output.txt")) {
                String result = PdfTextExtractor.getTextFromPage(doc.getPage(3));
                os.write(result.getBytes(Charset.forName("UTF-16")));
            }
        }
    }
}
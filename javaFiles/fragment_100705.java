import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class RightAlignDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("out.pdf");
        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);
        PDPageContentStream stream = new PDPageContentStream(doc, page);

        PDType1Font font = PDType1Font.TIMES_ROMAN;
        int fontSize = 12;

        stream.setFont(font, fontSize);

        double[] values = {0, 0.1, 0.01, 12.12, 123.12, 1234.12, 123456.12};

        int columnOneLeftX = 50;
        int columnTwoRightX = 170;
        int columnThreeOffsetX = 10;

        for (int i = 0; i < values.length; i++) {
            stream.beginText();
            stream.newLineAtOffset(columnOneLeftX, 700 - (i*10));
            // show some left aligned non fixed width text
            stream.showText("value " + values[i]);

            // format the double value with thousands separator and 
            // two decimals
            String text = String.format("%,.2f", values[i]);
            // get the width of the formated value
            float textWidth = getTextWidth(font, fontSize, text);
            // align the position to (right alignment minus text width)
            stream.newLineAtOffset(columnTwoRightX - textWidth, 0);
            stream.showText(text);

            // align the positon back to columnTwoRightX plus offset for
            // column three
            stream.newLineAtOffset(textWidth + columnThreeOffsetX, 0);
            stream.showText("description " + i);
            stream.endText();
        }

        stream.close();
        doc.save(file);
        doc.close();
    }

    private static float getTextWidth(PDType1Font font, int fontSize, 
            String text) throws IOException {
        return (font.getStringWidth(text) / 1000.0f) * fontSize;
    }
}
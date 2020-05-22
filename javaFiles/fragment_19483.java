import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.Phrase;

...

PdfContentByte canvas = writer.getDirectContent();
Phrase phrase = new Phrase(text2);
ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, phrase, 200, 572, 0);

Image img = Image.getInstance(image2);
img.setAbsolutePosition(200, 200);
canvas.addImage(img);
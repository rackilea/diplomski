import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.parser.Vector;
import com.itextpdf.text.Rectangle;
enum TextRenderMode{ FillText(0), StrokeText(1), FillThenStrokeText(2), Invisible(3),FillTextAndAddToPathForClipping(4),StrokeTextAndAddToPathForClipping(5), FillThenStrokeTextAndAddToPathForClipping(6),AddTextToPaddForClipping(7);
private int value;
private TextRenderMode(int value) {
    this.value = value;
}
public int getValue() {
    return value;
}
}
public class CustomizedTextExtractionStrategy implements   TextExtractionStrategy {
private StringBuilder result = new StringBuilder();
// Store last used properties
private Vector lastBaseLine;
private String lastFont;
private float lastFontSize;
@Override
public void endTextBlock() {
    // TODO Auto-generated method stub
}
@Override
public void renderImage(ImageRenderInfo imageRenderInfo) {
    // TODO Auto-generated method stub
}
@Override
public void renderText(TextRenderInfo renderInfo) {
// TODO Auto-generated method stub
String curFont = renderInfo.getFont().getPostscriptFontName();
// Check if faux bold is used
TextRenderMode mode = TextRenderMode.FillThenStrokeText;
int modeValue = mode.getValue();
if ((renderInfo.getTextRenderMode() == modeValue)) {
curFont += "-Bold";
}
// This code assumes that if the baseline changes then we're on a
// newline
Vector curBaseline = renderInfo.getBaseline().getStartPoint();
Vector topRight = renderInfo.getAscentLine().getEndPoint();
Rectangle rect = new Rectangle(curBaseline.get(Vector.I1),
curBaseline.get(Vector.I2), topRight.get(Vector.I1),
topRight.get(Vector.I2));
float curFontSize = rect.getHeight();
// See if something has changed, either the baseline, the font or the
// font size
if ((this.lastBaseLine == null)
|| (curBaseline.get(Vector.I2) != lastBaseLine.get(Vector.I2))
|| (curFontSize != lastFontSize) || (curFont != lastFont)) {
// if we've put down at least one span tag close it
if ((this.lastBaseLine != null)) {
// this.result.AppendLine("</span>");
}
// If the baseline has changed then insert a line break
if ((this.lastBaseLine != null)
&& curBaseline.get(Vector.I2) != lastBaseLine
.get(Vector.I2)) {
this.result.append(System.getProperty("line.separator"));
}
// Create an HTML tag with appropriate styles
this.result.append(curFont + "-" + curFontSize
+ System.getProperty("line.separator"));
}
// Append the current text
this.result.append(renderInfo.getText());
// Set currently used properties
this.lastBaseLine = curBaseline;
this.lastFontSize = curFontSize;
this.lastFont = curFont;
}
@Override
public String getResultantText() {
// TODO Auto-generated method stub
String words[] = result.toString().split(" ");
for (String word : words) {
System.out.println(word);
}
    return "Texts written on console successfully";
}

@Override
public void beginTextBlock() {
    // TODO Auto-generated method stub
    System.out
            .println("************** PDF Extraction Starts **************");
}
import java.io.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class HtmlParseDemo {
   public static void main(String [] args) throws Exception {
       Reader reader = new StringReader("foo <a href=\"#\">Link 1</a> bar <a href=\"#\">Link <b>2</b> more</a> baz");
       HTMLEditorKit.Parser parser = new ParserDelegator();
       parser.parse(reader, new LinkParser(), true);
       reader.close();
   }
}

class LinkParser extends HTMLEditorKit.ParserCallback {

    private boolean linkStarted = false;
    private StringBuilder b = new StringBuilder();

    public void handleText(char[] data, int pos) {
        if(linkStarted) b.append(new String(data));
    }

    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if(t == HTML.Tag.A) linkStarted = true;
    }

    public void handleEndTag(HTML.Tag t, int pos) {
        if(t == HTML.Tag.A) {
            linkStarted = false;
            System.out.println(b);
            b = new StringBuilder();
        }
    }
}
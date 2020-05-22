import java.io.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.*;

public class Foo {

    public static void main(String[] args) throws Exception {
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText("<p>This</p> <b>is</b> a <b>test</b>.");

        StringWriter writer = new StringWriter();
        HTMLDocument doc = (HTMLDocument) textPane.getStyledDocument();

        HTMLWriter htmlWriter = new OnlyBodyHTMLWriter(writer, doc);
        htmlWriter.write();

        System.out.println(writer.toString());
    }

    private static class OnlyBodyHTMLWriter extends HTMLWriter {

        public OnlyBodyHTMLWriter(Writer w, HTMLDocument doc) {
            super(w, doc);
        }

        private boolean inBody = false;

        private boolean isBody(Element elem) {
            // copied from HTMLWriter.startTag()
            AttributeSet attr = elem.getAttributes();
            Object nameAttribute = attr
                    .getAttribute(StyleConstants.NameAttribute);
            HTML.Tag name = null;
            if (nameAttribute instanceof HTML.Tag) {
                name = (HTML.Tag) nameAttribute;
            }
            return name == HTML.Tag.BODY;
        }

        @Override
        protected void startTag(Element elem) throws IOException,
                BadLocationException {
            if (inBody) {
                super.startTag(elem);
            }
            if (isBody(elem)) {
                inBody = true;
            }
        }

        @Override
        protected void endTag(Element elem) throws IOException {
            if (isBody(elem)) {
                inBody = false;
            }
            if (inBody) {
                super.endTag(elem);
            }
        }
    }
}
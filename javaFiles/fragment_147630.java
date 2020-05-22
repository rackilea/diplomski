import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Main {

    public static final String BOOK_TITLE = "User Guide";

    public static void main(String[] args) {

        Document doc = null;
        try {
            doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = doc.createElement("root");
            doc.appendChild(root);

            // Create callout node...
            Element callOut = doc.createElement("CallOut");

            // Get the user input...
            String text = "This is an example of a User Guide for you to read";
            // Does it contain our marker...?
            if (text.contains(BOOK_TITLE)) {
                // While the text contains the mark, continue looping...
                while (text.contains(BOOK_TITLE)) {
                    // Get the text before the marker...
                    String prefix = text.substring(0, text.indexOf(BOOK_TITLE));
                    // Get the text after the marker...
                    text = text.substring(text.indexOf(BOOK_TITLE) + BOOK_TITLE.length());
                    // If there is text before the marker, append it to the call out node
                    if (prefix.length() > 0) {
                        Text textNode = doc.createTextNode(prefix);
                        callOut.appendChild(textNode);
                    }
                    // Append the book title node...
                    Element bookTitle = doc.createElement("BookTitle");
                    bookTitle.setTextContent(BOOK_TITLE);
                    callOut.appendChild(bookTitle);
                }
                // If there is any text remaining, append it to the call out node...
                if (text.length() > 0) {
                    Text textNode = doc.createTextNode(text);
                    callOut.appendChild(textNode);
                }
            } else {
                // No marker, append the text to the call out node..
                Text textNode = doc.createTextNode(text);
                callOut.appendChild(textNode);
            }

            // This will dump the result for you to test....
            root.appendChild(callOut);
            ByteArrayOutputStream baos = null;
            OutputStreamWriter osw = null;

            try {

                baos = new ByteArrayOutputStream();
                osw = new OutputStreamWriter(baos);

                Transformer tf = TransformerFactory.newInstance().newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty(OutputKeys.METHOD, "xml");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

                DOMSource domSource = new DOMSource(doc);
                StreamResult sr = new StreamResult(osw);
                tf.transform(domSource, sr);

                osw.flush();
                baos.flush();
                System.out.println(new String(baos.toByteArray()));

            } finally {

                try {
                    baos.close();
                } catch (Exception exp) {
                }

            }

        } catch (IOException | TransformerException | ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }
}
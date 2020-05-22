import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Entry {
    public static void main(String[] args)
            throws IOException, ParserConfigurationException, TransformerException {
        String ns = "http://schemas.google.com/g/2005"; // just a guess
        DocumentBuilderFactory docBuildFactory = DocumentBuilderFactory.newInstance();
        docBuildFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder = docBuildFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element entry = doc.createElement("entry");
        entry.setAttributeNS(ns, "gd:etag", "*");
        doc.appendChild(entry);
        Element id = doc.createElement("id");
        id.setTextContent("Text");
        entry.appendChild(id);
        printDocument(doc, System.out);
    }

    public static void printDocument(Document doc, OutputStream out)
            throws IOException, TransformerException {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
        transformer.setOutputProperty(OutputKeys.METHOD, "xml");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        transformer.transform(new DOMSource(doc),
                new StreamResult(new OutputStreamWriter(out, "UTF-8")));
    }
}
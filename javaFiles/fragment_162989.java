import static org.junit.Assert.assertTrue;

import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class DomTest {

    @Test
    public void testDom() throws Exception {
        Document document = createEmptyDocument();

        Element root = document.getDocumentElement();
        Element child = document.createElement("child");
        Element childOfTheChild = document.createElement("childOfTheChild");
        Text st = document.createTextNode("Some text");
        childOfTheChild.appendChild(st);
        child.appendChild(childOfTheChild);
        root.appendChild(child);

        assertTrue(serialise(document).contains("Some text"));
    }

    private Document createEmptyDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DOMImplementation domImpl = dbf.newDocumentBuilder()
                .getDOMImplementation();
        Document document = domImpl.createDocument(null, "root", null);
        return document;
    }

    private String serialise(Document document)
            throws TransformerFactoryConfigurationError,
            TransformerConfigurationException, TransformerException {
        TransformerFactory xff = TransformerFactory.newInstance();
        Transformer xf = xff.newTransformer();
        StringWriter sw = new StringWriter();
        xf.transform(new DOMSource(document), new StreamResult(sw));
        return sw.toString();
    }
}
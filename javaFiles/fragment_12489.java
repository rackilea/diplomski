import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TitleHandler extends XmlAdapter<Object, String> {

    /**
     * Factory for building DOM documents.
     */
    private final DocumentBuilderFactory docBuilderFactory;
    /**
     * Factory for building transformers.
     */
    private final TransformerFactory transformerFactory;

    /**
     * XSLT that will strip the root element. Used to only take the content of an element given
     */
    private final static String UNMARSHAL_XSLT = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
"<xsl:transform xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\n" +
"\n" +
"    <xsl:output method=\"xml\" omit-xml-declaration=\"yes\" />\n" +
"\n" +
"    <xsl:template match=\"/*\">\n" +
"      <xsl:apply-templates select=\"@*|node()\"/>\n" +
"    </xsl:template>\n" +
"\n" +
"    <xsl:template match=\"@*|node()\">\n" +
"        <xsl:copy>\n" +
"            <xsl:apply-templates select=\"@*|node()\"/>\n" +
"        </xsl:copy>\n" +
"    </xsl:template>\n" +
"    \n" +
"</xsl:transform>";

    public TitleHandler() {
        docBuilderFactory = DocumentBuilderFactory.newInstance();
        transformerFactory = TransformerFactory.newInstance();
    }

    @Override
    public String unmarshal(Object v) throws Exception {
        // The provided Object is a DOM Element
        Element rootElement = (Element) v;
        // Creating a DOMSource as input for the transformer
        DOMSource source = new DOMSource(rootElement);
        // Creating a transformer that will strip away the root element
        StreamSource xsltSource = new StreamSource(new StringReader(UNMARSHAL_XSLT));
        Transformer transformer = transformerFactory.newTransformer(xsltSource);
        // Transform to a StringWriter
        StringWriter stringWriter = new StringWriter();
        StreamResult result = new StreamResult(stringWriter);
        transformer.transform(source, result);
        // Returning result as string
        return stringWriter.toString();
    }

    @Override
    public Object marshal(String v) throws Exception {
        // DOM document builder
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        // Creating a new empty document
        Document doc = docBuilder.newDocument();
        // Creating a DOMResult as output for the transformer
        DOMResult result = new DOMResult(doc);
        // Default transformer: identity tranformer (doesn't alter input)
        Transformer transformer = transformerFactory.newTransformer();
        // String reader from the input and source
        StringReader stringReader = new StringReader("<title>" + v + "</title>");
        StreamSource source = new StreamSource(stringReader);
        // Transforming input string to the DOM
        transformer.transform(source, result);
        // Return DOM root element for JAXB marshalling to XML
        return doc.getDocumentElement();
    }

}
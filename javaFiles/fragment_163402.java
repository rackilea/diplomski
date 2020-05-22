import java.io.*;    
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.sax.*;
import javax.xml.transform.stream.*;
import javax.xml.xpath.*;    
import org.w3c.dom.*;
import org.xml.sax.*;

public final class XmlHelper
{
    private static final XmlHelper instance = new XmlHelper(); 
    public static XmlHelper getInstance()
    {
        return instance;
    }


    private final SAXTransformerFactory transformerFactory;
    private final DocumentBuilderFactory documentBuilderFactory;
    private final XPathFactory xpathFactory;

    private XmlHelper()
    {
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setNamespaceAware(true);

        xpathFactory = XPathFactory.newInstance();

        TransformerFactory tf = TransformerFactory.newInstance();
        if (!tf.getFeature(SAXTransformerFactory.FEATURE))
            throw new RuntimeException("Failed to create SAX-compatible TransformerFactory.");
        transformerFactory = (SAXTransformerFactory) tf;
    }

    public DocumentBuilder newDocumentBuilder()
    {
        try
        {
            return documentBuilderFactory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e)
        {
            throw new RuntimeException("Failed to create new "+DocumentBuilder.class, e);
        }
    }

    public XPath newXPath()
    {
        return xpathFactory.newXPath();
    }

    public Transformer newIdentityTransformer(boolean omitXmlDeclaration, boolean indent)
    {
        try
        {
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, indent ? "yes" : "no");
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, omitXmlDeclaration ? "yes" : "no");
            return transformer;
        }
        catch (TransformerConfigurationException e)
        {
            throw new RuntimeException("Failed to create Transformer instance: "+e.getMessage(), e);
        }
    }

    public Templates newTemplates(String xslt) throws XmlException
    {
        try
        {
            return transformerFactory.newTemplates(new DOMSource(parse(xslt)));
        }
        catch (TransformerConfigurationException e)
        {
            throw new RuntimeException("Failed to create templates: "+e.getMessage(), e);
        }
    }

    public Document parse(String xml) throws XmlException
    {
        return parse(new InputSource(new StringReader(xml)));
    }

    public Document parse(InputSource xml) throws XmlException
    {
        try
        {
            return newDocumentBuilder().parse(xml);
        }
        catch (SAXException e)
        {
            throw new XmlException("Failed to parse xml: "+e.getMessage(), e);
        }
        catch (IOException e)
        {
            throw new XmlException("Failed to read xml: "+e.getMessage(), e);
        }
    }

    public String toString(Node node)
    {
        return toString(node, true, false);
    }

    public String toString(Node node, boolean omitXMLDeclaration, boolean indent)
    {
        try
        {
            StringWriter writer = new StringWriter();

            newIdentityTransformer(omitXMLDeclaration, indent)
                .transform(new DOMSource(node), new StreamResult(writer));

            return writer.toString();
        }
        catch (TransformerException e)
        {
            throw new RuntimeException("Failed to transform XML into string: " + e.getMessage(), e);
        }
    }

    public Document copy(Document document)
    {
        DOMSource source = new DOMSource(document);
        DOMResult result = new DOMResult();

        try
        {
            newIdentityTransformer(true, false)
                .transform(source, result);
            return (Document) result.getNode();
        }
        catch (TransformerException e)
        {
            throw new RuntimeException("Failed to copy XML: " + e.getMessage(), e);
        }
    }
}
import org.xml.sax.Attributes; 
import org.xml.sax.ContentHandler; 
import org.xml.sax.Locator; 
import org.xml.sax.SAXException; 
import org.xml.sax.XMLReader; 

public class IgnoringContentHandler implements ContentHandler { 

    private int depth = 1; 
    private XMLReader xmlReader; 
    private ContentHandler contentHandler; 

    public IgnoringContentHandler(XMLReader xmlReader, ContentHandler contentHandler) { 
        this.contentHandler = contentHandler; 
        this.xmlReader = xmlReader; 
    } 

    public void setDocumentLocator(Locator locator) { 
    } 

    public void startDocument() throws SAXException { 
    } 

    public void endDocument() throws SAXException { 
    } 

    public void startPrefixMapping(String prefix, String uri) 
            throws SAXException { 
    } 

    public void endPrefixMapping(String prefix) throws SAXException { 
    } 

    public void startElement(String uri, String localName, String qName, 
            Attributes atts) throws SAXException { 
        depth++; 
    } 

    public void endElement(String uri, String localName, String qName) 
            throws SAXException { 
        depth--; 
        if(0 == depth) { 
           xmlReader.setContentHandler(contentHandler); 
        } 
    } 

    public void characters(char[] ch, int start, int length) 
            throws SAXException { 
    } 

    public void ignorableWhitespace(char[] ch, int start, int length) 
            throws SAXException { 
    } 

    public void processingInstruction(String target, String data) 
            throws SAXException { 
    } 

    public void skippedEntity(String name) throws SAXException { 
    } 

}
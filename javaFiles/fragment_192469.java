import org.xml.sax.Attributes; 
import org.xml.sax.ContentHandler; 
import org.xml.sax.Locator; 
import org.xml.sax.SAXException; 
import org.xml.sax.XMLReader; 

public class MyContentHandler implements ContentHandler { 

    private XMLReader xmlReader; 

    public MyContentHandler(XMLReader xmlReader) { 
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
        if("sodium".equals(qName)) { 
            xmlReader.setContentHandler(new IgnoringContentHandler(xmlReader, this)); 
        } else { 
            System.out.println("START " + qName); 
        } 
    } 

    public void endElement(String uri, String localName, String qName) 
            throws SAXException { 
        System.out.println("END " + qName); 
    } 

    public void characters(char[] ch, int start, int length) 
            throws SAXException { 
        System.out.println(new String(ch, start, length)); 
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
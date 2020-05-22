import java.io.*;
import javax.xml.XMLConstants;
import javax.xml.parsers.*;
import javax.xml.validation.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class ParseDemo {

    public static void main(String[] args) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = sf.newSchema(new File("src/forum27528698/schema.xsd")); 

        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setSchema(schema);
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();
        xr.setContentHandler(new MyHandler());

        StringReader xml = new StringReader("<root><singleEmptyElement/><singlePopulatedElement>populated</singlePopulatedElement><listEmptyElement/><listPopulatedElement>populated</listPopulatedElement></root>");
        InputSource input = new InputSource(xml);
        xr.parse(input);
    }

    private static class MyHandler extends DefaultHandler {

        @Override
        public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
            System.out.print("<" + qName + ">");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            System.out.print(new String(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("</" + qName + ">");
        }

    }

}
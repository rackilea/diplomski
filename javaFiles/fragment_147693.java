package jaxb.test;

import java.io.StringReader;
import javax.xml.XMLConstants;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ValidationTest {

    public static void main(String[] args) throws Exception {

        //Test XML and schema
        final String xml = "<?xml version=\"1.0\"?><test><test2></test2></test>";
        final String schemaString =
            "<?xml version=\"1.0\"?>"
            + "<xsd:schema xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" elementFormDefault=\"unqualified\" attributeFormDefault=\"unqualified\">"
            + "<xsd:element name=\"test\" type=\"Test\"/>"
            + "<xsd:element name=\"test2\" type=\"Test2\"/>"
            + "<xsd:complexType name=\"Test\">"
            + "<xsd:sequence>"
            + "<xsd:element ref=\"test2\" minOccurs=\"1\" maxOccurs=\"unbounded\"/>"
            + "</xsd:sequence>"
            + "</xsd:complexType>"
            + "<xsd:simpleType name=\"Test2\">"
            + "<xsd:restriction base=\"xsd:string\"><xsd:minLength value=\"1\"/></xsd:restriction>"
            + "</xsd:simpleType>"
            + "</xsd:schema>";

        //Building a Schema instance
        final Source schemaSource =
            new StreamSource(new StringReader(schemaString));
        final Schema schema =
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(schemaSource);

        //Creating a SAXParser for our input XML
        //First the factory
        final SAXParserFactory factory = SAXParserFactory.newInstance();
        //Must be namespace aware to receive element names
        factory.setNamespaceAware(true);
        //Setting the Schema for validation
        factory.setSchema(schema);
        //Now the parser itself
        final SAXParser parser = factory.newSAXParser();

        //Creating an instance of our special handler
        final MyContentHandler handler = new MyContentHandler();

        //Parsing
        parser.parse(new InputSource(new StringReader(xml)), handler);

    }

    private static class MyContentHandler extends DefaultHandler {

        private String element = "";

        @Override
        public void startElement(String uri, String localName, String qName,
                Attributes attributes) throws SAXException {

            if(localName != null && !localName.isEmpty())
                element = localName;
            else
                element = qName;

        }

        @Override
        public void warning(SAXParseException exception) throws SAXException {
            System.out.println(element + ": " + exception.getMessage());
        }

        @Override
        public void error(SAXParseException exception) throws SAXException {
            System.out.println(element + ": " + exception.getMessage());
        }

        @Override
        public void fatalError(SAXParseException exception) throws SAXException {
            System.out.println(element + ": " + exception.getMessage());
        }

        public String getElement() {
            return element;
        }

    }

}
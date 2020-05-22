import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class XMLValidate {

static File xsd;
static File xml;
static URL url;
static StreamSource source;
static SchemaFactory schemaFactory;
static Schema schema;
static Validator validator;

/**
 * @param args
 */
public static void main(String[] args) {
    xml = new File("example.xml");
    xsd = new File("Live.xsd");

    try {
        url = new URL(xsd.toURI().toString());// xsd
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }

    source = new StreamSource(xml); // xml
    try {
        //System.out.println(url);
        schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        schema = schemaFactory.newSchema(url);
    } catch (SAXException e) {
        e.printStackTrace();
    }
    validator = schema.newValidator();
    //System.out.println(xml);
    try {
        validator.validate(source);
        System.out.println("Validation succesful!");
    } catch (SAXParseException e) {
        System.out.println("Validation failed!!!");
        //e.printStackTrace(); -- uncomment for detailed info on validation failing
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
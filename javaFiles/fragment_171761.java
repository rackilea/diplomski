import java.io.File;  
import java.io.FileInputStream;

import javax.xml.XMLConstants;  
import javax.xml.bind.JAXBContext;  
import javax.xml.bind.Unmarshaller;  
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;  
import javax.xml.validation.SchemaFactory;  

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
public class TestParser {    
    public static void main(String[] pArgs) {  
        try {  
            JAXBContext context = JAXBContext.newInstance(RootElement.class);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  

            SchemaFactory schemaFac = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema sysConfigSchema = schemaFac.newSchema(
                    new File("example.xsd"));

            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            spf.setSchema(sysConfigSchema);
            XMLReader xmlReader = spf.newSAXParser().getXMLReader();
            SAXSource source = new SAXSource(xmlReader, new InputSource(new FileInputStream("example1.xml")));
            RootElement root = (RootElement)unmarshaller.unmarshal(
                    source);
            System.out.println("Child Val: " + root.getChild().getChildVal());
            System.out.println("Child Attr: " + root.getChild().getAttr());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
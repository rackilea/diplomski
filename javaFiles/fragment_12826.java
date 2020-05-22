import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import com.piyush.STDMP;


public class Test {

    /**
     * @param args
     * @throws JAXBException 
     * @throws SAXException 
     */
    public static void main(String[] args) throws JAXBException, SAXException {
        JAXBContext jaxbContext = JAXBContext.newInstance(STDMP.class);
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource(new File("C:/Users/CDAC/workspace/Testing/src/STD_MP.xsd")));
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        jaxbUnmarshaller.setSchema(schema);
        STDMP ts = (STDMP)jaxbUnmarshaller.unmarshal(new File("E:/Testing.xml"));

        System.out.println(ts.getCoordSystems());
        System.out.println(ts.getEDocument());

    }

     }
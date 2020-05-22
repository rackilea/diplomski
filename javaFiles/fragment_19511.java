package forum12295028;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.bind.*;
import javax.xml.bind.util.ValidationEventCollector;
import javax.xml.validation.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
        Schema schema = sf.newSchema(new File("src/forum12295028/customer.xsd")); 

        JAXBContext jc = JAXBContext.newInstance(Customer.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        ValidationEventCollector validationCollector = new JAXB2ValidationEventCollector();
        unmarshaller.setEventHandler(validationCollector);

        Customer customer = (Customer) unmarshaller.unmarshal(new File("src/forum12295028/input.xml"));

        if(validationCollector.hasEvents())
        {
            for(ValidationEvent event:validationCollector.getEvents())
            {
                String msg = event.getMessage();
                System.out.println(msg);
            }
        }
    }

}
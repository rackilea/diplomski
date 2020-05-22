package forum10699038;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;

import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        // READ FROM XML
        JAXBContext jcXML = JAXBContext.newInstance(Metadata.class);

        File xml = new File("src/forum10699038/input.xml");
        Unmarshaller unmarshaller = jcXML.createUnmarshaller();
        Metadata metadata = (Metadata) unmarshaller.unmarshal(xml);

        // WRITE TO JSON
        Map<String, Object> properties = new HashMap<String, Object>(3);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum10699038/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jcJSON = JAXBContext.newInstance(new Class[] {Metadata.class}, properties);

        Marshaller marshaller = jcJSON.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(metadata, System.out);
    }

}
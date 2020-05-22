package forum23939109;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        // Create Instance of Domain Model
        Foo foo = new Foo();
        ArrayList<Integer> values = new ArrayList<Integer>();
        values.add(0);
        values.add(1);
        values.add(2);
        values.add(4);
        foo.setValues(values);

        // Marshal Object to XML Based on Annotations
        JAXBContext jcXML = JAXBContext.newInstance(Foo.class);
        Marshaller marshallerXML = jcXML.createMarshaller();
        marshallerXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerXML.marshal(foo, System.out);

        // Marshal Object to JSON Based on Annotations & External Mappings
        Map<String, Object> properties = new HashMap<String, Object>(3);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum23939109/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, org.eclipse.persistence.oxm.MediaType.APPLICATION_JSON);
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jcJSON = JAXBContext.newInstance(new Class[] {Foo.class}, properties);
        Marshaller marshallerJSON = jcJSON.createMarshaller();
        marshallerJSON.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshallerJSON.marshal(foo, System.out);
    }

}
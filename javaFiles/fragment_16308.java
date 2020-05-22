package forum11450509;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Root.class}, properties);

        Root root = new Root();
        root.setFoo("ABC");
        root.setBar(123);

        System.out.println("One Line:");
        Marshaller marshaller = jc.createMarshaller();
        marshaller.marshal(root, System.out);

        System.out.println("\nFormatted:");
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(root, System.out);
    }

}
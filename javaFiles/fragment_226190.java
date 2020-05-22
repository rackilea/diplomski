package forum11451880;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;
import org.eclipse.persistence.jaxb.MarshallerProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum11451880/oxm.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {LifeSpan.class}, properties);

        LifeSpan lifeSpan = new LifeSpan();
        lifeSpan.begin = "1999-04";
        lifeSpan.end = "true";

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(lifeSpan, System.out);

        marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
        marshaller.marshal(lifeSpan, System.out);
    }

}
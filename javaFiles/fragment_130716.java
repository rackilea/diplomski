package forum383861;

import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

public class Demo {

    public static void main(String[] args) throws Exception {
        ReleaseGroup rg = new ReleaseGroup();
        rg.type = "Album";
        rg.title = "Fred";

        // XML
        JAXBContext xmlJC = JAXBContext.newInstance(ReleaseGroup.class);
        Marshaller xmlMarshaller = xmlJC.createMarshaller();
        xmlMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        xmlMarshaller.marshal(rg, System.out);

        // JSON
        Map<String, Object> properties = new HashMap<String, Object>(2);
        properties.put(JAXBContextProperties.OXM_METADATA_SOURCE, "forum383861/oxm.xml");
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        JAXBContext jsonJC = JAXBContext.newInstance(new Class[] {ReleaseGroup.class}, properties);
        Marshaller jsonMarshaller = jsonJC.createMarshaller();
        jsonMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jsonMarshaller.marshal(rg, System.out);
    }

}
package forum13318677;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String,Object>();
        properties.put("eclipselink.oxm.metadata-source", "forum13318677/oxm.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {TopNoControlClass.class}, properties);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        File xml = new File("src/forum13318677/input.xml");
        TopNoControlClass object = (TopNoControlClass) unmarshaller.unmarshal(xml);

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, System.out);
    }

}
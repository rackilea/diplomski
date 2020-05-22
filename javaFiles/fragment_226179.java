package forum10174513;

import java.io.File;
import java.util.*;
import javax.xml.bind.*;
import org.eclipse.persistence.jaxb.JAXBContextFactory;

public class Demo {

    public static void main(String[] args) throws Exception {
        Map<String, Object> properties = new HashMap<String, Object>(1);
        properties.put(JAXBContextFactory.ECLIPSELINK_OXM_XML_KEY, "forum10174513/bindings.xml");
        JAXBContext jc = JAXBContext.newInstance(new Class[] {Root.class, BaseBeanEx.class}, properties);

        File xml = new File("src/forum10174513/input.xml");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(xml);
    }

}